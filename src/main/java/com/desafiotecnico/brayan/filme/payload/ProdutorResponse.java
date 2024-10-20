package com.desafiotecnico.brayan.filme.payload;

import java.util.List;

public class ProdutorResponse {

    public ProdutorResponse(String produtor,
                            Integer intervalo,
                            Integer vitoriaAnterior,
                            Integer vitoriaSeguinte) {
        this.producer = produtor;
        this.interval = intervalo;
        this.previousWin = vitoriaAnterior;
        this.followingWin = vitoriaSeguinte;
    }

    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;

    public String getProducer() {
        return producer;
    }

    public Integer getInterval() {
        return interval;
    }

    public Integer getPreviousWin() {
        return previousWin;
    }

    public Integer getFollowingWin() {
        return followingWin;
    }
}
