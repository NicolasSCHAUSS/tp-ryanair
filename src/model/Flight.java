package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_flight", sequenceName = "seq_flight", initialValue = 1, allocationSize = 1)
public class Flight {

	@Id
	@GeneratedValue(generator="seq_flight")
	private int id;
	@Column(nullable=true,unique=true, length=4)
	private String number;
	@Column(nullable=true)
	@Enumerated(EnumType.STRING)
	private Plane plane;
	@Column(nullable=true)
	private int seatsNumber;
	@Column(nullable=true)
	private String departureCity;
	@Column(nullable=true)
	private String arrivalCity;
	@Column(nullable=true)
	private LocalDate departureDate;
	
	@OneToMany(mappedBy="bookedPassenger")
	public List<Booking> flight = new ArrayList<Booking>();
	
	public Flight()
	{
	}
	
	public Flight(String number, Plane plane, String dCity, String aCity, LocalDate date)
	{
		this.number = number;
		this.plane = plane;
		this.seatsNumber = plane.getMaxSeat();
		this.departureCity = dCity;
		this.arrivalCity = aCity;
		this.departureDate = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the plane
	 */
	public Plane getPlane() {
		return plane;
	}

	public int getPassengerLimit() {
		return seatsNumber;
	}

	public void setPassengerLimit(int passengerLimit) {
		this.seatsNumber = passengerLimit;
	}

	/**
	 * @param plane the plane to set
	 */
	public void setPlane(String plane) {
		this.plane = Plane.valueOf(plane);
		this.seatsNumber = Plane.valueOf(plane).getMaxSeat();
	}

	/**
	 * @return the departureCity
	 */
	public String getDepartureCity() {
		return departureCity;
	}

	/**
	 * @param departureCity the departureCity to set
	 */
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	/**
	 * @return the arrivalCity
	 */
	public String getArrivalCity() {
		return arrivalCity;
	}

	/**
	 * @param arrivalCity the arrivalCity to set
	 */
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	/**
	 * @return the departureDate
	 */
	public LocalDate getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	
	public String toString()
	{
		return this.number+"\t| "+
				this.plane.name()+"\t| "+
				this.seatsNumber+"\t| "+
				this.departureCity+"\t| "+
				this.arrivalCity+"\t| "+
				this.departureDate;
	}
}
