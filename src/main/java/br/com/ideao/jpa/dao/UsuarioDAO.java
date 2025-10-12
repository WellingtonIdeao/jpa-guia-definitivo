package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class UsuarioDAO {
    private EntityManager manager;

    public UsuarioDAO() {
        this.manager = JpaUtil.getEntityManager();
    }

    public void close() {
        this.manager.close();
    }

    public void batchUpdate() {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Query query = manager.createQuery("update Usuario set ativo = false where email like :email");
        query.setParameter("email", "%@gmail.com");

        int linhasAfetadas = query.executeUpdate();
        System.out.println(linhasAfetadas + " registro(s) atualizado(s).");

        transaction.commit();
    }

    public void batchDelete() {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Query query = manager.createQuery("delete from Usuario where ativo = false");

        int linhasExcluidas = query.executeUpdate();
        System.out.println(linhasExcluidas + " registros removidos.");

        transaction.commit();
    }
}
