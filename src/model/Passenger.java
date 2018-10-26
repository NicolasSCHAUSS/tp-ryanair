package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_passenger", sequenceName = "seq_passenger", initialValue = 1, allocationSize = 1)
public class Passenger {

	@Id
	@GeneratedValue(generator="seq_passenger")
	private int id;
	@Column(nullable=true)
	private String firstname;
	@Column(nullable=true)
	private String lastname;
	@Column(nullable=true)
	private int yearsOld;
	
	@OneToMany(mappedBy="reservedFlight")
	public List<Booking> passenger = new ArrayList<Booking>();
	
	
	public Passenger(String first, String last, int yOld)
	{
		this.firstname = first;
		this.lastname = last;
		this.yearsOld = yOld;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the yearsOld
	 */
	public int getYearsOld() {
		return yearsOld;
	}

	/**
	 * @param yearsOld the yearsOld to set
	 */
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
}
