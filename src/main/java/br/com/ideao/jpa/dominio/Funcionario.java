package br.com.ideao.jpa.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "pessoa_codigo")
public class Funcionario extends Pessoa {

    @Column(nullable = true)
    private BigDecimal salario;

    @Column(nullable = true)
    private String cargo;

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}