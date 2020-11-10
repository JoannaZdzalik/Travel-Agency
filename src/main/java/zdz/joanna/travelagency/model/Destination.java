package zdz.joanna.travelagency.model;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="destinations")
public class Destination implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(nullable= false)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "destination")
	List<Trip> trips;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Trip> getTrips() {
		return trips;
	}
	
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public Destination(String name, List<Trip> trips) {
		super();
		this.name = name;
		this.trips = trips;
	}

	public Destination(String name) {
		super();
		this.name = name;
	}

	public Destination() {
		super();
	}
}
