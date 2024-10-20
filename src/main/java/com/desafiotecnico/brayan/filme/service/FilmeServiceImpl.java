package com.desafiotecnico.brayan.filme.service;

import com.desafiotecnico.brayan.filme.Filme;
import com.desafiotecnico.brayan.filme.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilmeServiceImpl implements FilmeService {

    private FilmeRepository filmeRepository;

    public FilmeServiceImpl(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Map<String, Object> getIntervaloPremios() {
        List<Filme> vencedores = filmeRepository.findByWinnerTrue();

        Map<String, Object> response = new HashMap<>();

        return response;
    }
}
