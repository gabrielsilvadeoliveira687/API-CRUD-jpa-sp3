package br.com.gabrielsoliveira.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlaceRepository extends ReactiveCrudRepository<Place , Long>{
    
}
