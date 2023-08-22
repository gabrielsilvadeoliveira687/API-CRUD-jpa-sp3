package br.com.gabrielsoliveira.domain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.slugify.Slugify;

import br.com.gabrielsoliveira.api.PlaceRequest;
import reactor.core.publisher.Mono;


public class PlaceService {
    private PlaceRepository placeRepository;
    private Slugify slg;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slg = Slugify.builder().build();   
        }

    public Mono<Place> create(PlaceRequest placeRequest){
       var place= new Place(null, placeRequest.name(), slg.slugify(placeRequest.name()),
       placeRequest.state(), null, null);
    	return placeRepository.save(place);
    } 
      
}
