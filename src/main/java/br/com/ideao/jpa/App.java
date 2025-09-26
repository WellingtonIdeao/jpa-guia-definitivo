package br.com.ideao.jpa;

import br.com.ideao.jpa.dao.VeiculoDAO;
import br.com.ideao.jpa.dominio.TipoCombustivel;
import br.com.ideao.jpa.dominio.Veiculo;
import br.com.ideao.jpa.dominio.VeiculoId;
import br.com.ideao.jpa.util.JpaUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class App {
	public static void main(String[] args) {
        VeiculoDAO veiculoDAO = new VeiculoDAO();

        Veiculo veiculo = new Veiculo();
        VeiculoId id = new VeiculoId("ABC-1234", "João Pessoa");

        veiculo.setCodigo(id);
        veiculo.setFabricante("Honda");
        veiculo.setModelo("Civic");
        veiculo.setAnoFabricacao(2020);
        veiculo.setAnoModelo(2020);
        veiculo.setValor(new BigDecimal(90500));
        veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo.setDataCadastro(LocalDate.now());

        veiculoDAO.persist(veiculo);
        System.out.println(veiculoDAO.find(id));
        System.out.println(veiculoDAO.findByReference(id));

        veiculoDAO.update(id, 102000.0);
//        veiculoDAO.remove(id);

        veiculoDAO.persistenceContext();
        veiculoDAO.persistDetached();
        show(veiculoDAO.list());
        veiculoDAO.close();
        JpaUtil.close();
    }

    private static void show(List<Veiculo> veiculos) {
        for (Veiculo v: veiculos) {
            System.out.println(v);
        }
    }
}