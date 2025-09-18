package br.com.ideao.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
        System.out.println("Hello World, Jakarta Persistence API - JPA");
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("br.com.ideao.jpa-pu");
                entityManagerFactory.close();
    }
}