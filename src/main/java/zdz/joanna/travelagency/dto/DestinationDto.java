package zdz.joanna.travelagency.dto;

import java.util.List;


public class DestinationDto {
	
	private Long id;
	private String name;
	List<TripDto> trips;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TripDto> getTrips() {
		return trips;
	}
	public void setTrips(List<TripDto> trips) {
		this.trips = trips;
	}
	public Long getId() {
		return id;
	}
	public DestinationDto() {
		super();
	}
	public DestinationDto(String name, List<TripDto> trips) {
		super();
		this.name = name;
		this.trips = trips;
	}
	public DestinationDto(String name) {
		super();
		this.name = name;
	}
	
	

}
