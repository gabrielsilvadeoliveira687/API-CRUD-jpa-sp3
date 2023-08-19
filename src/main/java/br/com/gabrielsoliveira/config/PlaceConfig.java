package br.com.gabrielsoliveira.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.gabrielsoliveira.domain.PlaceRepository;
import br.com.gabrielsoliveira.domain.PlaceService;

@Configuration
public class PlaceConfig {

	@Bean
	PlaceService placeService(PlaceRepository placeRepository) {
	return new PlaceService(placeRepository);
}
}
