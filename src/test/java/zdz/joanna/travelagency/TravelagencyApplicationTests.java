package zdz.joanna.travelagency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import zdz.joanna.travelagency.dto.ClientDto;
import zdz.joanna.travelagency.model.Client;
import zdz.joanna.travelagency.repository.ClientRepository;
import zdz.joanna.travelagency.service.ClientService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = TravelagencyApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class TravelagencyApplicationTests {

	@Autowired
	ClientService clientService;
//
//	@Mock
//	ClientRepository clientRepository;
//
//	@BeforeEach
//	void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//	}

	@Before
	public void init() throws Exception {
		clientService = new ClientService();
	}
	
	@Test
	public void shouldCreateClientWithAllValidParameters() {
		ClientDto client = new ClientDto("Karol", "Iks", "12qw34f");
		Assert.assertTrue(clientService.addClient(client));
	}
	
	@Test
	public void shouldbeok () {
		int a =5;
		Assert.assertEquals(5,a);
	}
	
	@Test
	public void shouldNotCreateClientPassportNrDuplicate() {
		ClientDto client1 = new ClientDto("Roman", "Super", "rety");
		clientService.addClient(client1);
		ClientDto clientDuplicate = new ClientDto("Janina", "Bidenowa", "rety");
		Assert.assertFalse(clientService.addClient(clientDuplicate));
	}

}
