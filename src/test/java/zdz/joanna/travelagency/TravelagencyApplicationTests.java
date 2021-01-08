package zdz.joanna.travelagency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import zdz.joanna.travelagency.dto.ClientDto;
import zdz.joanna.travelagency.dto.DestinationDto;
import zdz.joanna.travelagency.dto.GuideDto;
import zdz.joanna.travelagency.dto.ReservationDto;
import zdz.joanna.travelagency.dto.TripDto;
import zdz.joanna.travelagency.service.ClientService;
import zdz.joanna.travelagency.service.ReservationService;

@SpringBootTest(classes = TravelagencyApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class TravelagencyApplicationTests {

//	@Autowired
//	ClientService clientService;
//	
//	@Autowired
//	ReservationService reservationService;
//
//	@Before
//	public void init() throws Exception {
//		clientService = new ClientService();
//		reservationService = new ReservationService();
//	}
//	
//	@Test
//	public void shouldCreateClientWithAllValidParameters() {
//		ClientDto clientDto = new ClientDto("Karol", "Iks", "12qw34f");
//		Assert.assertTrue(clientService.addClient(clientDto));
//	}
//	
//	@Test
//	public void shouldNotCreateClientPassportNrDuplicate() {
//		ClientDto client1 = new ClientDto("Roman", "Super", "rety");
//		clientService.addClient(client1);
//		ClientDto clientDuplicate = new ClientDto("Janina", "Bidenowa", "rety");
//		Assert.assertFalse(clientService.addClient(clientDuplicate));
//	}
//	
//	@Test
//	public void shouldCheckIfActualPriceIsValid() {
//		ClientDto cl = new ClientDto("Tadeusz", "Iks", "UI897435");
//		GuideDto guide = new GuideDto("Arek");
//		DestinationDto dest = new DestinationDto ("Tarnobrzeg");
//		BigDecimal suggestedPrice = new BigDecimal("1800");
//		TripDto trip = new TripDto (dest, LocalDate.now().plusDays(10L), LocalDate.now().plusDays(20L), suggestedPrice, guide);
//		BigDecimal actualPrice1 = new BigDecimal ("1700");
//		BigDecimal actualPrice2 = new BigDecimal ("1900");
//		
//		ReservationDto res1 = new ReservationDto(cl, trip, actualPrice1);
//		ReservationDto res2 = new ReservationDto(cl, trip, actualPrice2);
//		
//		Assert.assertTrue(reservationService.isValid(res1));
//		Assert.assertFalse(reservationService.isValid(res2));
//	}
	
	
}
