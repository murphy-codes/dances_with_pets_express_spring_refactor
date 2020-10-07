package com.launchacademy.danceswithpetsexpressspringrefactor.repositories;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.SurrenderApplication;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SurrenderApplicationRepository extends PagingAndSortingRepository<SurrenderApplication, Integer> {
  public SurrenderApplication findFirstById(Integer applicationId);
}
