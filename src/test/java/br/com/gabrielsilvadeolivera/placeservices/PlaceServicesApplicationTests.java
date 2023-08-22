package br.com.gabrielsilvadeolivera.placeservices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.gabrielsoliveira.api.PlaceRequest;
import io.netty.handler.codec.http2.Http2Stream.State;

@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
class PlaceServicesApplicationTests {
	@Autowired
	WebTestClient webTestClient;

	@Test
	public void testCreatePlaceSuccss() {
		var name ="valid name";
		var state="valid state";
		var slug = "valid-name";
		
		webTestClient
		.post()
		.uri("/places")
		.bodyValue(
				new PlaceRequest(name,state))
		.exchange()
		.expectBody()
		.jsonPath("name").isEqualTo(name)
		.jsonPath("state").isEqualTo(state)
		.jsonPath("slug").isEqualTo(slug)
		.jsonPath("createdAt").isNotEmpty()
		.jsonPath("updatedAt").isNotEmpty();
		
		
	}
	
	@Test
	public void testCreatePlaceFailure() {
		var name ="";
		var state ="";
		
		webTestClient
		.post()
		.uri("/places")
		.bodyValue(
		new PlaceRequest(name,state))
		.exchange()
		.expectStatus().isBadRequest();
		
	}
}
