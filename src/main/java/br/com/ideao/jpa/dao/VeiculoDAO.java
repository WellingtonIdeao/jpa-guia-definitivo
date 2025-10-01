package br.com.ideao.jpa.dao;

import br.com.ideao.jpa.dominio.Acessorio;
import br.com.ideao.jpa.dominio.TipoCombustivel;
import br.com.ideao.jpa.dominio.Veiculo;
import br.com.ideao.jpa.dominio.VeiculoId;
import br.com.ideao.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class VeiculoDAO {
    private EntityManager manager;

    public VeiculoDAO() {
        this.manager = JpaUtil.getEntityManager();
    }

    public void persist(Veiculo veiculo) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        manager.persist(veiculo.getProprietario());
        manager.persist(veiculo);

        transaction.commit();
    }

    public Veiculo find(VeiculoId id) {
        return manager.find(Veiculo.class, id);
    }

    public Veiculo findByReference(VeiculoId id) {
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

    public void update(VeiculoId id, Double newValue) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Veiculo veiculo = manager.find(Veiculo.class, id);
        veiculo.setValor(new BigDecimal(newValue));

        transaction.commit();
    }

    public void remove(VeiculoId id) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Veiculo veiculo = manager.find(Veiculo.class, id);
        manager.remove(veiculo);

        transaction.commit();
    }

    public void persistenceContext() {

        VeiculoId id = new VeiculoId("ABC-1234", "João Pessoa");

        Veiculo v1 = manager.find(Veiculo.class, id);
        System.out.println("Buscou o veículo pela primeira vez...");

        System.out.println("Gerenciado? " + manager.contains(v1));
        manager.detach(v1);
        System.out.println("E agora? " + manager.contains(v1));

        Veiculo v2 = manager.find(Veiculo.class, id);
        System.out.println("Buscou o veículo pela segunda vez...");

        System.out.println("Mesmo veículo? " + (v1 == v2));
    }

    public void persistDetached() {
        VeiculoId id = new VeiculoId("ABC-1234", "João Pessoa");

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Veiculo veiculo = manager.find(Veiculo.class, id);

        transaction.commit();

        manager.close();
        veiculo.setValor(new BigDecimal(120_000));

        manager = JpaUtil.getEntityManager();
        transaction = manager.getTransaction();
        transaction.begin();

        veiculo = manager.merge(veiculo);

        transaction.commit();
    }

    public void persistVeiculosAndAcessorios() {

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Acessorio roda = new Acessorio();
        roda.setDescricao("Roda de liga leve");

        Acessorio sensor = new Acessorio();
        sensor.setDescricao("Sensores de estacionamento");

        Acessorio mp3 = new Acessorio();
        mp3.setDescricao("MP3 Player");

        Acessorio pintura = new Acessorio();
        pintura.setDescricao("Pintura metalizada");

        manager.persist(roda);
        manager.persist(sensor);
        manager.persist(mp3);
        manager.persist(pintura);

        VeiculoId veiculoCod1 = new VeiculoId("DEF-1234", "Recife");

        Veiculo veiculo1 = new Veiculo();
        veiculo1.setCodigo(veiculoCod1);
        veiculo1.setFabricante("VW");
        veiculo1.setModelo("Gol");
        veiculo1.setAnoFabricacao(2018);
        veiculo1.setAnoModelo(2018);
        veiculo1.setValor(new BigDecimal(17_200));
        veiculo1.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo1.setDataCadastro(LocalDate.now());

        veiculo1.getAcessorios().add(roda);
        veiculo1.getAcessorios().add(mp3);

        VeiculoId veiculoCod2 = new VeiculoId("GHI-1234", "Maceió");

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setCodigo(veiculoCod2);
        veiculo2.setFabricante("Hyundai");
        veiculo2.setModelo("i30");
        veiculo2.setAnoFabricacao(2019);
        veiculo2.setAnoModelo(2019);
        veiculo2.setValor(new BigDecimal(53_500));
        veiculo2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo2.setDataCadastro(LocalDate.now());

        veiculo2.getAcessorios().add(roda);
        veiculo1.getAcessorios().add(mp3);
        veiculo1.getAcessorios().add(pintura);

        manager.persist(veiculo1);
        manager.persist(veiculo2);

        transaction.commit();
    }
}
