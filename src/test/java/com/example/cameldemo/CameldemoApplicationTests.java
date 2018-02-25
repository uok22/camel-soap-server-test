package com.example.cameldemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CameldemoApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() {
		String string = testRestTemplate.getForObject("/", String.class);

		RestTemplate restTemplate = new RestTemplate();

		Object object = restTemplate.getForObject("http://localhost:57575/kappas", Object.class);

		Object object2 = restTemplate.postForObject("http://localhost:57575/kappas", "posti: katitmukaan", String.class);

		System.out.println();
	}

}
