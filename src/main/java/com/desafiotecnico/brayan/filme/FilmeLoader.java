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

    private FilmeService filmeService;

    public FilmeLoader(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @Override
    public void run(String... args) throws Exception {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader("src/main/resources/movielist.csv"))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] nextLine;

            reader.readNext(); // Pula o header

            while ((nextLine = reader.readNext()) != null) {
                filmeService.saveFilme(
                        Integer.parseInt(nextLine[0]),
                        nextLine[1],
                        nextLine[2],
                        nextLine[3],
                        "yes".equals(nextLine[4])
                );
            }
        }
    }
}