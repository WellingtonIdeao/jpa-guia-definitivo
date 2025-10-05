package br.com.ideao.jpa.dominio;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "pessoa_codigo")
public class Cliente extends Pessoa {

    @Column(name = "limite_credito", nullable = true)
    private BigDecimal limiteCredito;

    @Column(name = "renda_mensal", nullable = true)
    private BigDecimal rendaMensal;

    @Column(nullable = true)
    private boolean bloqueado;

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public BigDecimal getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(BigDecimal rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}
