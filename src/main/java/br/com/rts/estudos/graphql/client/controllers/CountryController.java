package br.com.rts.estudos.graphql.client.controllers;

import br.com.rts.estudos.graphql.client.entities.Country;
import br.com.rts.estudos.graphql.client.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryController {

    private final CountryService service;

    @GetMapping
    public Mono<List<Country>> getAllCountries() {
        return service.getAllCountries();
    }
}
