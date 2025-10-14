package br.com.ideao.jpa.dto;

public class TotalCarroPorAno {
    private Integer anoFabricacao;
    private Double mediaPreco;
    private Long qtdCarros;

    public TotalCarroPorAno(Integer anoFabricacao, Double mediaPreco, Long qtdCarros) {
        this.anoFabricacao = anoFabricacao;
        this.mediaPreco = mediaPreco;
        this.qtdCarros = qtdCarros;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public Double getMediaPreco() {
        return mediaPreco;
    }

    public Long getQtdCarros() {
        return qtdCarros;
    }
}
