package br.com.ideao.jpa;

import br.com.ideao.jpa.dao.VeiculoDAO;
import br.com.ideao.jpa.dominio.Veiculo;
import br.com.ideao.jpa.util.JpaUtil;

import java.math.BigDecimal;

public class App {
	public static void main(String[] args) {
        VeiculoDAO veiculoDAO = new VeiculoDAO();

        Veiculo veiculo = new Veiculo();
        veiculo.setFabricante("Honda");
        veiculo.setModelo("Civic");
        veiculo.setAnoFabricacao(2020);
        veiculo.setAnoModelo(2020);
        veiculo.setValor(new BigDecimal(90500));

        veiculoDAO.persist(veiculo);
        JpaUtil.close();
    }
}