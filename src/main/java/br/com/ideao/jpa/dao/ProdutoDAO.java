package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.dominio.Produto;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProdutoDAO {
    private EntityManager manager;

    public ProdutoDAO() {
        this.manager  = JpaUtil.getEntityManager();
    }

    public void close() {
        this.manager.close();
    }

    public void list() {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Produto produto = manager.find(Produto.class, 3L);
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Categoria: " + produto.getCategoria().getNome());
    }
}
