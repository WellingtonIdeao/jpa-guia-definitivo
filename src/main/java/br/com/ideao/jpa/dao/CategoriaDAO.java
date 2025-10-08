package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.dominio.Categoria;
import br.com.ideao.jpa.dominio.Produto;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Arrays;

public class CategoriaDAO {
    private EntityManager manager;

    public CategoriaDAO() {
        this.manager = JpaUtil.getEntityManager();
    }

    public void close() {
        this.manager.close();
    }

    public void list() {
        Categoria categoria = manager.find(Categoria.class, 1L);

        System.out.println("Categoria: " + categoria.getNome());
        for (Produto p : categoria.getProdutos()) {
            System.out.println("Produto: " + p.getNome());
        }
    }

    public void addCategoriAndProdutos() {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Categoria categoria = new Categoria();
        categoria.setNome("Carnes");

        Produto produto = new Produto();
        produto.setNome("Picanha");
        produto.setCategoria(categoria);

        categoria.setProdutos(Arrays.asList(produto));

        manager.persist(categoria);

        transaction.commit();
    }
}
