package br.com.ideao.jpa.dominio;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VeiculoId implements Serializable {
    private String placa;
    private String cidade;

    public VeiculoId() {
    }

    public VeiculoId(String placa, String cidade) {
        this.placa = placa;
        this.cidade = cidade;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VeiculoId veiculoId = (VeiculoId) o;
        return Objects.equals(placa, veiculoId.placa) && Objects.equals(cidade, veiculoId.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa, cidade);
    }

    @Override
    public String toString() {
        return  this.placa + " " + this.cidade;
    }
}
