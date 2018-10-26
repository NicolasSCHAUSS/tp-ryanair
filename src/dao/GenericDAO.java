package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GenericDAO<T> {
	
	private Class<T> classType;
	
	public GenericDAO(Class<T> classType)
	{
		this.setClassType(classType);
	}

	public Class<T> getClassType() {
		return classType;
	}

	public void setClassType(Class<T> classType) {
		this.classType = classType;
	}
	
	public T create(T t)
	{
		EntityManager em = DatabaseHelper.createEntityManager();
		try{
			DatabaseHelper.beginTx(em);
			em.persist(t);
			DatabaseHelper.commitTxAndClose(em);
			return t;
		}
		catch (IllegalStateException e){
			DatabaseHelper.rollbackTxAndClose(em);
			throw new RuntimeException(e);
		}
	}
	
	public List<T> findAll()
	{
		EntityManager em = DatabaseHelper.createEntityManager();
		
		TypedQuery<T> query = em.createQuery("from "+classType.getName(), classType);
		return query.getResultList();
		
	}
	
	public T read(int id)
	{
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		EntityManager entityManager = DatabaseHelper.createEntityManager();
        T t = entityManager.find(this.classType, id);
        entityManager.close();
        return t;

	}
	
	public T update(T t)
	{
		EntityManager em = DatabaseHelper.createEntityManager();		
		try{
			DatabaseHelper.beginTx(em);
			em.merge(t);
			DatabaseHelper.commitTxAndClose(em);
			return t;
		}
		catch (IllegalStateException e){
			DatabaseHelper.rollbackTxAndClose(em);
			throw new RuntimeException(e);
		}
	}

	public void delete(int id)
	{
		EntityManager em = DatabaseHelper.createEntityManager();
		try{
			DatabaseHelper.beginTx(em);
			em.remove(em.find(this.classType,id));
			DatabaseHelper.commitTxAndClose(em);
		}
		catch (IllegalStateException e){
			DatabaseHelper.rollbackTxAndClose(em);
			throw new RuntimeException(e);
		}
	}
}
