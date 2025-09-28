package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.dominio.Proprietario;
import br.com.ideao.jpa.dominio.Veiculo;
import br.com.ideao.jpa.dominio.VeiculoId;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class ProprietarioDAO {
    private EntityManager manager;

    public ProprietarioDAO() {
        this.manager = JpaUtil.getEntityManager();
    }

    public void close() {
        this.manager.close();
    }

    public Veiculo getVeiculo(Long id) {
        Proprietario proprietario = this.manager.find(Proprietario.class, id);
        return proprietario.getVeiculo();
    }
}
