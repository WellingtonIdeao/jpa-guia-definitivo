package br.com.ideao.jpa;

import br.com.ideao.jpa.dao.VeiculoDAO;
import br.com.ideao.jpa.dominio.Veiculo;
import br.com.ideao.jpa.util.JpaUtil;

import java.math.BigDecimal;
import java.util.List;

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
//        System.out.println(veiculoDAO.find(3L));
//        System.out.println(veiculoDAO.findByReference(3L));

        List<Veiculo> veiculos = veiculoDAO.list();
        show(veiculos);
        veiculoDAO.close();
        JpaUtil.close();
    }

    private static void show(List<Veiculo> veiculos) {
        for (Veiculo v: veiculos) {
            System.out.println(v);
        }
    }
}