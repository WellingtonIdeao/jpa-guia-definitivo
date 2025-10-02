package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.dominio.Cliente;
import br.com.ideao.jpa.dominio.Funcionario;
import br.com.ideao.jpa.dominio.Pessoa;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.List;

public class FuncionarioDAO {
    private EntityManager manager;

    public FuncionarioDAO() {
       this.manager = JpaUtil.getEntityManager();
    }

    public void close() {
       this.manager.close();
    }

    public void persist(Funcionario funcionario) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        funcionario.setNome("Fernando");
        funcionario.setCargo("Gerente");
        funcionario.setSalario(new BigDecimal(12_000));

        manager.persist(funcionario);

        transaction.commit();
    }

    public void list() {
        Query query = manager.createQuery("select f from Funcionario f", Funcionario.class);
        List<Funcionario> funcionarios = query.getResultList();

        for (Funcionario func: funcionarios) {
            System.out.println("Funcionario: " + func.getNome() + " - " + func.getSalario());
        }
    }

    public void listPessoas() {
        Query query = manager.createQuery("select p from Pessoa p", Pessoa.class);
        List<Pessoa> pessoas = query.getResultList();

        for (Pessoa p : pessoas) {
            System.out.print(p.getNome());
            if (p instanceof Cliente) {
                System.out.println(" - é um cliente");
            } else {
                System.out.println(" - é um funcionário");
            }
        }
    }
}
