package br.com.ideao.jpa.dto;

import java.math.BigDecimal;

public class PrecoVeiculo {

    private String modelo;
    private BigDecimal valor;

    public PrecoVeiculo(String modelo, BigDecimal valor) {
        this.modelo = modelo;
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
