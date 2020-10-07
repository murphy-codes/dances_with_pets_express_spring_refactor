package com.launchacademy.danceswithpetsexpressspringrefactor.repositories;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.PetType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PetTypeRepository extends PagingAndSortingRepository<PetType, Integer> {
  public boolean existsByBreed(String breed);
  public PetType findFirstById(Integer petTypeId);
}
