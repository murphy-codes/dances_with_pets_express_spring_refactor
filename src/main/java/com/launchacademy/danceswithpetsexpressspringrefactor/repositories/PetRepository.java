package com.launchacademy.danceswithpetsexpressspringrefactor.repositories;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PetRepository extends PagingAndSortingRepository<Pet, Integer> {
  public boolean existsByName(String petName);
  public Optional<Pet> findByName(String petName);
  public Pet findFirstById(Integer petId);
  public Pet findFirstByName(String petName);
  public Page<Pet> findByAdoptionStatusFalse(Pageable pageable);
  public Page<Pet> findByAdoptionStatusTrue(Pageable pageable);

  @Query("SELECT p FROM Pet p INNER JOIN PetType t ON p.petType = t.id WHERE p.adoptionStatus = false AND classification = ?1")
  public Page<Pet> getByClassification(@Param("grouping") String grouping, Pageable pageable);

  @Query("SELECT p FROM Pet p INNER JOIN PetType t ON p.petType = t.id WHERE p.adoptionStatus = false AND type = ?1")
  public Page<Pet> getByType(@Param("grouping") String grouping, Pageable pageable);

  @Query("SELECT p FROM Pet p INNER JOIN PetType t ON p.petType = t.id WHERE p.adoptionStatus = false AND breed = ?1")
  public Page<Pet> getByBreed(@Param("grouping") String grouping, Pageable pageable);
}
