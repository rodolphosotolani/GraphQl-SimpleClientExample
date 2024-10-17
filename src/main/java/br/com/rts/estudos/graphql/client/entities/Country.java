package br.com.rts.estudos.graphql.client.entities;

public record Country(
        String name,
        String emoji,
        String currency,
        String code,
        String capital
) {
}
