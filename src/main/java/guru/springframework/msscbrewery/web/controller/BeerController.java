package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.services.ServerInfo;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @Autowired
    ServerInfo serverInfo;

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> createNewBeer(BeerDto newBeer) {
        BeerDto savedBeer = beerService.saveBeer(newBeer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", getLocationValue(savedBeer.getId()));

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    private String getLocationValue(UUID id) {
        return "http://" + serverInfo.getHostname() + ":" + serverInfo.getPort() + "/api/v1/beer/" + id.toString();
    }

}
