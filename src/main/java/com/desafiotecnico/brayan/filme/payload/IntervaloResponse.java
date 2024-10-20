package com.desafiotecnico.brayan.filme.payload;

import java.util.List;

public class IntervaloResponse {

    public IntervaloResponse(List<ProdutorResponse> menor,
                             List<ProdutorResponse> maior) {
        this.min = menor;
        this.max = maior;
    }

    private List<ProdutorResponse> min;
    private List<ProdutorResponse> max;

    public List<ProdutorResponse> getMin() {
        return min;
    }

    public List<ProdutorResponse> getMax() {
        return max;
    }
}
