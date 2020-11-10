package zdz.joanna.travelagency.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zdz.joanna.travelagency.dto.ReservationDto;
import zdz.joanna.travelagency.model.Reservation;
import zdz.joanna.travelagency.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public boolean createReservation(ReservationDto reservationDto) {
		if (isValid(reservationDto)) {
			Reservation res = mapper.map(reservationDto, Reservation.class);
			try {
				reservationRepository.save(res);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	public boolean isValid(ReservationDto r) {
		int result = r.getActualPrice().compareTo(r.getTrip().getSuggestedPrice());
		if((result == 0 || result ==-1) && r!= null ) {
			return true;
		}
		return false;
	}
	

}
