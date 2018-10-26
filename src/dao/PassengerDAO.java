package dao;

import model.Passenger;

public class PassengerDAO extends GenericDAO<Passenger> {

	public PassengerDAO() {
		super(Passenger.class);
		
		create(new Passenger("passe","PARTT",55));
		create(new Passenger("felindra","TIGRE",65));
		create(new Passenger("pere","FOURAS",147));
	}

	public void createFromConsole() {
		
		
	}

}
