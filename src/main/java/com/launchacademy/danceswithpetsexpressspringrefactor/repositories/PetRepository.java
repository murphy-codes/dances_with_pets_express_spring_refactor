package com.launchacademy.danceswithpetsexpressspringrefactor.repositories;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.Pet;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PetRepository extends PagingAndSortingRepository<Pet, Integer> {
  public boolean existsByName(String petName);
  public Pet findFirstById(Integer petId);
}
