package br.com.rts.estudos.graphql.client.services.impl;

import br.com.rts.estudos.graphql.client.entities.Country;
import br.com.rts.estudos.graphql.client.services.CountryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Log4j2
@Service
public class CountryServiceImpl implements CountryService {

    private final HttpGraphQlClient graphQlClient;

    public CountryServiceImpl() {
        WebClient client = WebClient.builder().baseUrl("https://countries.trevorblades.com").build();
        graphQlClient = HttpGraphQlClient.builder(client).build();
    }


    @Override
    public Mono<List<Country>> getAllCountries() {
        //language=GraphQL
        String document = """
                query{
                    countries{
                        name
                        emoji
                        currency
                        code
                        capital
                    }
                }
                """;

        return graphQlClient
                .document(document)
                .retrieve("countries")
                .toEntityList(Country.class);
    }
}
