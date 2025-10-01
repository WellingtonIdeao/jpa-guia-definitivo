package br.com.ideao.jpa;

import br.com.ideao.jpa.dao.ProprietarioDAO;
import br.com.ideao.jpa.dao.VeiculoDAO;
import br.com.ideao.jpa.dominio.Proprietario;
import br.com.ideao.jpa.dominio.TipoCombustivel;
import br.com.ideao.jpa.dominio.Veiculo;
import br.com.ideao.jpa.dominio.VeiculoId;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class App {
	public static void main(String[] args) {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        ProprietarioDAO proprietarioDAO = new ProprietarioDAO();

        Veiculo veiculo = new Veiculo();
        VeiculoId id = new VeiculoId("ABC-1234", "João Pessoa");

        StringBuilder especificacoes = new StringBuilder();
        especificacoes.append("Carro em excelente estado.\n");
        especificacoes.append("Completo, menos ar.\n");
        especificacoes.append("Primeiro dono, com manual de instrução ");
        especificacoes.append("e todas as revisões feitas.\n");
        especificacoes.append("IPVA pago, aceita financiamento.");

        Proprietario proprietario = new Proprietario();
        proprietario.setNome("João das Couves");
        proprietario.setTelefone("(99) 1234-5678");

        veiculo.setCodigo(id);
        veiculo.setFabricante("Honda");
        veiculo.setModelo("Civic");
        veiculo.setAnoFabricacao(2020);
        veiculo.setAnoModelo(2020);
        veiculo.setValor(new BigDecimal(90500));
        veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo.setDataCadastro(LocalDate.now());
        veiculo.setEspecificacoes(especificacoes.toString());
        veiculo.setProprietario(proprietario);

        veiculoDAO.persist(veiculo);
        System.out.println(veiculoDAO.find(id));
        try {
            System.out.println(veiculoDAO.findByReference(id));
        } catch (EntityNotFoundException ex) {
            System.out.println("Veiculo não encontrado!");
        }

        veiculoDAO.update(id, 102000.0);
//        veiculoDAO.remove(id);

        veiculoDAO.persistenceContext();
        veiculoDAO.persistDetached();
        show(veiculoDAO.list());

        show(proprietarioDAO.getVeiculos(1L));
        veiculoDAO.persistVeiculosAndAcessorios();

        veiculoDAO.close();
        proprietarioDAO.close();
        JpaUtil.close();
    }

    private static void show(List<Veiculo> veiculos) {
        for (Veiculo v: veiculos) {
            System.out.println(v);
        }
    }
}