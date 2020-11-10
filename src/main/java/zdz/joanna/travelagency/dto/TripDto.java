package zdz.joanna.travelagency.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TripDto {

	private Long id;
	private DestinationDto destination;
	private LocalDate departureDate;
	private LocalDate returnDate;
	private BigDecimal suggestedPrice;
	private GuideDto guide;
	List<ReservationDto> reservations;
	public DestinationDto getDestination() {
		return destination;
	}
	public void setDestination(DestinationDto destination) {
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
	public GuideDto getGuide() {
		return guide;
	}
	public void setGuide(GuideDto guide) {
		this.guide = guide;
	}
	public List<ReservationDto> getReservations() {
		return reservations;
	}
	public void setReservations(List<ReservationDto> reservations) {
		this.reservations = reservations;
	}
	public Long getId() {
		return id;
	}
	public TripDto() {
		super();
	}
	public TripDto(DestinationDto destination, LocalDate departureDate, LocalDate returnDate, BigDecimal suggestedPrice,
			GuideDto guide, List<ReservationDto> reservations) {
		super();
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.suggestedPrice = suggestedPrice;
		this.guide = guide;
		this.reservations = reservations;
	}
	public TripDto(DestinationDto destination, LocalDate departureDate, LocalDate returnDate, BigDecimal suggestedPrice,
			GuideDto guide) {
		super();
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.suggestedPrice = suggestedPrice;
		this.guide = guide;
	}
	
	
	
	

}
