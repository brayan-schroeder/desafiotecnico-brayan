package com.desafiotecnico.brayan.filme;

import com.desafiotecnico.brayan.filme.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("filmes")
public class FilmeController {

    private FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping("intervalo_premios")
    public Map<String, Object> intervaloPremios() {
        return filmeService.getIntervaloPremios();
    }
}
