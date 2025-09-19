package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.dominio.Veiculo;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VeiculoDAO {
    private EntityManager manager;

    public VeiculoDAO() {
        this.manager = JpaUtil.getEntityManager();
    }

    public void persist(Veiculo veiculo) {
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.persist(veiculo);
        transaction.commit();
    }

    public Veiculo find(Long id) {
        return manager.find(Veiculo.class, id);
    }

    public Veiculo findByReference(Long id) {
        return manager.getReference(Veiculo.class, id);
    }

    public void close() {
        manager.close();
    }
}
