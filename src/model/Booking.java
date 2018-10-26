package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_booking", sequenceName = "seq_booking", initialValue = 1, allocationSize = 1)
public class Booking {

	@Id
	@GeneratedValue(generator="seq_booking")
	private int id;
	
	@ManyToOne
	public Flight reservedFlight;
	
	@ManyToOne
	public Passenger bookedPassenger;
	
}
