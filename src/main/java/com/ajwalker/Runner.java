package com.ajwalker;

import com.ajwalker.entity.Player;
import com.ajwalker.repository.RepositoryManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Futbol_ManagerV2");
    }
}