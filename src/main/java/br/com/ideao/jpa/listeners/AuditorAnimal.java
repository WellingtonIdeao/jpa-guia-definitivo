package br.com.ideao.jpa.listeners;

import br.com.ideao.jpa.dominio.Animal;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class AuditorAnimal {

    @PrePersist
    @PreUpdate
    public void updateDataUltimaAtualizacao(Animal animal) {
        animal.setDataUltimaAtualizacao(LocalDateTime.now());
    }
}
