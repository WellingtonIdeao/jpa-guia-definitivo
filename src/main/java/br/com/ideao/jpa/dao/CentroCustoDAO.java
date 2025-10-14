package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.dominio.CentroCusto;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class CentroCustoDAO {

    public void querySecondLevelCache() {
        EntityManager manager1 = JpaUtil.getEntityManager();
        CentroCusto centro1 = manager1.find(CentroCusto.class, 1L);
        System.out.println("Centro de custo: " + centro1.getNome());
        manager1.close();

        System.out.println("------");

        EntityManager manager2 = JpaUtil.getEntityManager();
        CentroCusto centro2 = manager2.find(CentroCusto.class, 1L);
        System.out.println("Centro de custo: " + centro2.getNome());
        manager2.close();
    }
}
