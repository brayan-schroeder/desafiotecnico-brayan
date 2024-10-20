package com.desafiotecnico.brayan.filme;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByWinnerTrue();
}
