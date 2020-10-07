package com.launchacademy.danceswithpetsexpressspringrefactor.repositories;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.AdoptionApplication;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdoptionApplicationRepository extends PagingAndSortingRepository<AdoptionApplication, Integer> {
  public AdoptionApplication findFirstById(Integer applicationId);
}
