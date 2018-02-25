package com.example.cameldemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {CamelDemoApplication.class, CamelDemoApplicationTests.SoapServerConfig.class})
public class CamelDemoApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() {
		String string = testRestTemplate.getForObject("/", String.class);

		RestTemplate restTemplate = new RestTemplate();

//		Object object = restTemplate.getForObject("http://localhost:57575/kappas", Object.class);

		Object object2 = restTemplate.postForObject("http://localhost:57575/kappas", "posti: katitmukaan", String.class);

		System.out.println();
	}

	@Test
	public void soapTest() {

		DemoPayloadObject payloadObject = new DemoPayloadObject();
		payloadObject.setName("NAME :: demo payload object");
		Object o = testRestTemplate.postForObject("/soap", payloadObject, String.class);


	}


	@Configuration
	static class SoapServerConfig {

		@Bean
		CamelHttpServer camelHttpServer() {
			return new CamelHttpServer();
		}
	}

}
