package com.desafiotecnico.brayan.filme;

import org.springframework.stereotype.Component;

@Component
public class FilmeFactory {

    public Filme create(Integer ano, String titulo, String estudio, String produtor, Boolean venceu) {
        Filme filme = new Filme();

        filme.setMovieYear(ano);
        filme.setTitle(titulo);
        filme.setStudio(estudio);
        filme.setProducer(produtor);
        filme.setWinner(venceu);

        return filme;
    }
}
