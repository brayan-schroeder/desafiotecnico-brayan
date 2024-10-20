package com.desafiotecnico.brayan.filme.service;

import com.desafiotecnico.brayan.filme.payload.IntervaloResponse;

public interface FilmeService {

    void saveFilme(Integer ano, String titulo, String estudio, String produtor, Boolean venceu);

    IntervaloResponse getIntervaloPremios();
}
