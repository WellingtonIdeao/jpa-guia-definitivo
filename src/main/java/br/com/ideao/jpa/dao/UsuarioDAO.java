package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.dominio.Usuario;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
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

    public void testConcurrency() {
        EntityManager manager1 = JpaUtil.getEntityManager();
        EntityTransaction tx1 = manager1.getTransaction();
        tx1.begin();

        EntityManager manager2 = JpaUtil.getEntityManager();
        EntityTransaction tx2 = manager2.getTransaction();
        tx2.begin();

        Usuario u1 = manager1.find(Usuario.class, 1L);
        u1.setEmail("maria@mail.com");

        Usuario u2 = manager2.find(Usuario.class, 1L);
        u2.setEmail("jose@mail.com");

        tx1.commit();
        manager1.close();

        tx2.commit();
        manager2.close();
    }

    public void testConcurrencyPessimistic() {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Usuario usuario = manager.find(Usuario.class, 1L, LockModeType.PESSIMISTIC_WRITE);
        usuario.setEmail("new@mail.com");

        transaction.commit();
    }
}
