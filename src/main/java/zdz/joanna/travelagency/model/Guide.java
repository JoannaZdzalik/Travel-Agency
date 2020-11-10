package zdz.joanna.travelagency.model;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@SuppressWarnings("serial")
@Table(name = "guides")
@Entity
public class Guide implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "guide")
	List<Trip> trips;



	public Guide(String name) {
		super();
		this.name = name;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public Long getId() {
		return id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Guide(String name, List<Trip> trips) {
		super();
		this.name = name;
		this.trips = trips;
	}

	public Guide() {
		super();
	}

	

	
	
	
	

}
