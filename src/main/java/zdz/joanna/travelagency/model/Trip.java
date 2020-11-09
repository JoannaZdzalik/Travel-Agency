package zdz.joanna.travelagency.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
@Table(name = "trips")
public class Trip implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_destination")
	private Destination destination;
	
	@Column(name = "departureDate", nullable = false)
	private LocalDate departureDate;
	
	@Column(name = "returnDate", nullable = false)
	private LocalDate returnDate;
	
	@Column(name = "suggestedPrice", nullable = false)
	private BigDecimal suggestedPrice = new BigDecimal("1200.5");

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_guide")
	private Guide guide;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trip")
	List<Reservation> reservations;

	public Trip(Destination destination, LocalDate departureDate, LocalDate returnDate, BigDecimal suggestedPrice,
			Guide guide) {
		super();
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.suggestedPrice = suggestedPrice;
		this.guide = guide;
	}
	
	
	public Trip() {
		super();
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public BigDecimal getSuggestedPrice() {
		return suggestedPrice;
	}

	public void setSuggestedPrice(BigDecimal suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Long getId() {
		return id;
	}
	
	

}
