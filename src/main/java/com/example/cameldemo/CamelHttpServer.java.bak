package com.example.cameldemo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelHttpServer extends RouteBuilder{
	@Override
	public void configure() throws Exception {

		from("jetty:http://localhost:57575/kappas")
				.convertBodyTo(String.class)
				.process(exchange -> {
					System.out.println("*********  HiiohOi ::  " + exchange.getIn().getBody().toString());
				});
	}
}
