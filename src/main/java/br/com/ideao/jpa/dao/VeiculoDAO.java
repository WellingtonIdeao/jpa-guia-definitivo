package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.dominio.Veiculo;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.util.List;

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

    public List<Veiculo> list() {
        Query query = manager.createQuery("SELECT v FROM Veiculo v");
        List<Veiculo> veiculos =  query.getResultList();
        return veiculos;
    }

    public void update(Long id, Double newValue) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Veiculo veiculo = manager.find(Veiculo.class, id);
        veiculo.setValor(new BigDecimal(newValue));

        transaction.commit();
    }

    public void remove(Long id) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Veiculo veiculo = manager.find(Veiculo.class, id);
        manager.remove(veiculo);

        transaction.commit();
    }

    public void persistenceContext() {

        Veiculo v1 = manager.find(Veiculo.class, 1L);
        System.out.println("Buscou o veículo pela primeira vez...");

        System.out.println("Gerenciado? " + manager.contains(v1));
        manager.detach(v1);
        System.out.println("E agora? " + manager.contains(v1));

        Veiculo v2 = manager.find(Veiculo.class, 1L);
        System.out.println("Buscou o veículo pela segunda vez...");

        System.out.println("Mesmo veículo? " + (v1 == v2));
    }

}
