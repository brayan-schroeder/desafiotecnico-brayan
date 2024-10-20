package com.desafiotecnico.brayan.filme.service;

import com.desafiotecnico.brayan.filme.Filme;
import com.desafiotecnico.brayan.filme.FilmeFactory;
import com.desafiotecnico.brayan.filme.FilmeRepository;
import com.desafiotecnico.brayan.filme.payload.IntervaloResponse;
import com.desafiotecnico.brayan.filme.payload.ProdutorResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilmeServiceImpl implements FilmeService {

    private FilmeRepository filmeRepository;
    private FilmeFactory filmeFactory;

    public FilmeServiceImpl(FilmeRepository filmeRepository,
                            FilmeFactory filmeFactory) {
        this.filmeRepository = filmeRepository;
        this.filmeFactory = filmeFactory;
    }

    public void saveFilme(Integer ano, String titulo, String estudio, String produtor, Boolean venceu) {
        Filme filme = filmeFactory.create(ano, titulo, estudio, produtor, venceu);

        filmeRepository.save(filme);
    }

    public IntervaloResponse getIntervaloPremios() {
        List<Filme> vencedores = filmeRepository.findByWinnerTrue();

        Map<String, List<Integer>> anosVencedoresProdutores = new HashMap<>();

        for (Filme filme : vencedores) {
            anosVencedoresProdutores.putIfAbsent(filme.getProducer(), new ArrayList<>());
            anosVencedoresProdutores.get(filme.getProducer()).add(filme.getMovieYear());
        }

        List<ProdutorResponse> menoresIntervalos = new ArrayList<>();
        List<ProdutorResponse> maioresIntervalos = new ArrayList<>();

        int maiorIntervalo = 0;
        int menorInteralo = Integer.MAX_VALUE;

        for (Map.Entry<String, List<Integer>> produtor : anosVencedoresProdutores.entrySet()) {
            List<Integer> anosVitoriosos = produtor.getValue();

            Collections.sort(anosVitoriosos);

            if (anosVitoriosos.size() > 1) {
                for (int i = 1; i < anosVitoriosos.size(); i++) {
                    int intervalo = anosVitoriosos.get(i) - anosVitoriosos.get(i - 1);

                    if (intervalo < menorInteralo) {
                        menorInteralo = intervalo;

                        menoresIntervalos.clear();
                        menoresIntervalos.add(new ProdutorResponse(produtor.getKey(), intervalo, anosVitoriosos.get(i - 1), anosVitoriosos.get(i)));
                    } else if (intervalo == menorInteralo) {
                        menoresIntervalos.add(new ProdutorResponse(produtor.getKey(), intervalo, anosVitoriosos.get(i - 1), anosVitoriosos.get(i)));
                    }

                    if (intervalo > maiorIntervalo) {
                        maiorIntervalo = intervalo;

                        maioresIntervalos.clear();
                        maioresIntervalos.add(new ProdutorResponse(produtor.getKey(), intervalo, anosVitoriosos.get(i - 1), anosVitoriosos.get(i)));
                    } else if (intervalo == maiorIntervalo) {
                        maioresIntervalos.add(new ProdutorResponse(produtor.getKey(), intervalo, anosVitoriosos.get(i - 1), anosVitoriosos.get(i)));
                    }
                }
            }
        }

        return new IntervaloResponse(menoresIntervalos, maioresIntervalos);
    }
}
