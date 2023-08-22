package br.com.gabrielsoliveira.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import br.com.gabrielsoliveira.api.PlaceRequest;
import br.com.gabrielsoliveira.api.PlaceResponse;
import br.com.gabrielsoliveira.domain.Place;
import br.com.gabrielsoliveira.domain.PlaceService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid  @RequestBody PlaceRequest request) {
        var placeResponse  = placeService.create(request).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }

}
 
