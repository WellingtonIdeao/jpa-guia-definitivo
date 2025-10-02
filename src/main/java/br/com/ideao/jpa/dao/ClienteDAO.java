package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.dominio.Cliente;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.util.List;

public class ClienteDAO {
    private EntityManager manager;

    public ClienteDAO() {
        this.manager = JpaUtil.getEntityManager();
    }

    public void close() {
        this.manager.close();
    }

    public void persist(Cliente cliente) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        cliente.setNome("Mariana");
        cliente.setRendaMensal(new BigDecimal(8_500));
        cliente.setLimiteCredito(new BigDecimal(2_000));
        cliente.setBloqueado(true);

        manager.persist(cliente);

        transaction.commit();
    }

    public void list() {
        Query query = manager.createQuery("select c from Cliente c", Cliente.class);
        List<Cliente> clientes = query.getResultList();

        for (Cliente cl: clientes) {
            System.out.println("Cliente: " + cl.getNome() + " - " + cl.getRendaMensal());
        }
    }
}
