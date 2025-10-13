package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.dominio.Animal;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;

public class AnimalDAO {
    private EntityManager manager;

    public AnimalDAO() {
        this.manager = JpaUtil.getEntityManager();
    }

    public void close() {
        this.manager.close();
    }

    public void persist() {
        EntityTransaction transaction  = manager.getTransaction();
        transaction.begin();

        Animal animal = new Animal();
        animal.setNome("Mimosa");
        animal.setDataNascimento(LocalDate.now().minusYears(5));

        System.out.println("Idade antes de persistir: " + animal.getIdade());
        manager.persist(animal);
        System.out.println("Idade depois de persistir: " + animal.getIdade());

        transaction.commit();
    }
}
