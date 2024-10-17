package br.com.rts.estudos.graphql.client.services;

import br.com.rts.estudos.graphql.client.entities.Country;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CountryService {
    Mono<List<Country>> getAllCountries();
}
