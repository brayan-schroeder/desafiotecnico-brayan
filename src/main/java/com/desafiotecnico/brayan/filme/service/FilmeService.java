package com.desafiotecnico.brayan.filme.service;

import java.util.List;
import java.util.Map;

public interface FilmeService {

    void saveFilme(Integer ano, String titulo, String estudio, String produtor, Boolean venceu);

    Map<String, List<Map<String, Object>>> getIntervaloPremios();
}
