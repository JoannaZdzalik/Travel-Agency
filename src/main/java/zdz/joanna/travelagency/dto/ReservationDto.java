package zdz.joanna.travelagency.dto;

import java.math.BigDecimal;

public class ReservationDto {
	
	private Long id;
	private ClientDto client;
	private TripDto trip;
	private BigDecimal actualPrice;
	public ClientDto getClient() {
		return client;
	}
	public void setClient(ClientDto client) {
		this.client = client;
	}
	public TripDto getTrip() {
		return trip;
	}
	public void setTrip(TripDto trip) {
		this.trip = trip;
	}
	public BigDecimal getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(BigDecimal actualPrice) {
		this.actualPrice = actualPrice;
	}
	public Long getId() {
		return id;
	}
	public ReservationDto() {
		super();
	}
	public ReservationDto(ClientDto client, TripDto trip, BigDecimal actualPrice) {
		super();
		this.client = client;
		this.trip = trip;
		this.actualPrice = actualPrice;
	}
	
	
	
	
	

}
