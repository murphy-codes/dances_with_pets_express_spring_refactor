package com.launchacademy.danceswithpetsexpressspringrefactor.seeders;

import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.PetRepository;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.PetTypeRepository;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.AdoptionApplicationRepository;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.SurrenderApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
  @Autowired private PetRepository petRepository;
  @Autowired private PetSeeder petSeeder;
  @Autowired private PetTypeRepository petTypeRepository;
  @Autowired private PetTypeSeeder petTypeSeeder;
  @Autowired private AdoptionApplicationRepository adoptionApplicationRepository;
  @Autowired private AdoptionApplicationSeeder adoptionApplicationSeeder;
  @Autowired private SurrenderApplicationRepository surrenderApplicationRepository;
  @Autowired private SurrenderApplicationSeeder surrenderApplicationSeeder;

  @Override public void run(String... args) throws Exception {
    petTypeSeeder.seed(petTypeRepository);
    petSeeder.seed(petTypeRepository, petRepository);
    adoptionApplicationSeeder.seed(adoptionApplicationRepository, petRepository);
    surrenderApplicationSeeder.seed(petTypeRepository, surrenderApplicationRepository);
  }
}