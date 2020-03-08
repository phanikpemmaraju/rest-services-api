package uk.co.legacy.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = RestServicesApiApplication.class)
public class RestServicesApiApplicationTest {

	@Test
	public void contextLoads() {
	}

}
