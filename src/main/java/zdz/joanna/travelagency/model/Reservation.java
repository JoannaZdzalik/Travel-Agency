package zdz.joanna.travelagency.model;

import java.math.BigDecimal;
import java.io.Serializable;
import javax.persistence.*;
@SuppressWarnings("serial")
@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "id_trip")
	private Trip trip;

	@Column(name="actualPrice",nullable = false)
	BigDecimal actualPrice;

	public Reservation(Client client, Trip trip, BigDecimal actualPrice) {
		this.client = client;
		this.trip = trip;
		this.actualPrice = actualPrice;
	}

	public Reservation() {
		super();
	}
	
	
}
