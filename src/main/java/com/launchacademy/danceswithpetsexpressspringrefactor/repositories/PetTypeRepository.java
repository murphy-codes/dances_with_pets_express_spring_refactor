package com.launchacademy.danceswithpetsexpressspringrefactor.repositories;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.PetType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PetTypeRepository extends PagingAndSortingRepository<PetType, Integer> {
  public boolean existsByBreed(String breed);
  public PetType findFirstById(Integer petTypeId);
  public PetType findFirstByBreed(String breed);

@Query("SELECT DISTINCT p.classification FROM PetType AS p ORDER BY classification")
  public Page<PetType> getClassifications(Pageable pageable);

@Query("SELECT DISTINCT p.type FROM PetType AS p ORDER BY type")
public Page<PetType> getTypes(Pageable pageable);

//  @Query("SELECT breed, id FROM PetType AS p ORDER BY classification, type, breed")
@Query("SELECT DISTINCT p.breed FROM PetType AS p ORDER BY breed")
  public Page<PetType> getBreeds(Pageable pageable);

//  public PetType findFirstByClassification(String classification);
//  public PetType findFirstByType(String type);

//    const queryString = `SELECT pets.id AS id, name, pet_img_url, age, vaccination_status, pets.description AS description, adoption_story, ` +
//      `adoption_status, pet_type_id, classification, type, breed, breed_img_url, pet_types.description AS pet_type_description FROM pets ` +
//      `INNER JOIN pet_types ON pet_type_id = pet_types.id WHERE adoption_status = ${adoptionStatus} AND ${grouping} = '${groupingId}'`;
}
