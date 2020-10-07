package com.launchacademy.danceswithpetsexpressspringrefactor.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
  @Autowired private AdoptionApplicationSeeder adoptionApplicationSeeder;
  @Autowired private PetSeeder petSeeder;
  @Autowired private PetTypeSeeder petTypeSeeder;
  @Autowired private SurrenderApplicationSeeder surrenderApplicationSeeder;

  @Override public void run(String... args) throws Exception {
    petTypeSeeder.seed();
    petSeeder.seed();
    adoptionApplicationSeeder.seed();
    surrenderApplicationSeeder.seed();
  }
}