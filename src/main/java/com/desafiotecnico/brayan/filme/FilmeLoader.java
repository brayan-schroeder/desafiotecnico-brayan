package com.desafiotecnico.brayan.filme;

import com.desafiotecnico.brayan.filme.service.FilmeService;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Component
public class FilmeLoader implements CommandLineRunner {

    private FilmeRepository filmeRepository;

    public FilmeLoader(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader("src/main/resources/movielist.csv"))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] nextLine;
            reader.readNext(); // Pula o header

            while ((nextLine = reader.readNext()) != null) {
                Filme filme = new Filme();

                filme.setMovieYear(Integer.parseInt(nextLine[0]));
                filme.setTitle(nextLine[1]);
                filme.setStudio(nextLine[2]);
                filme.setProducer(nextLine[3]);
                filme.setWinner("yes".equals(nextLine[4]));

                filmeRepository.save(filme);
            }
        }
    }
}