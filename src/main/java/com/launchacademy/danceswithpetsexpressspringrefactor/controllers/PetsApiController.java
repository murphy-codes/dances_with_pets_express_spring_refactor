package com.launchacademy.danceswithpetsexpressspringrefactor.controllers;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.Pet;
import com.launchacademy.danceswithpetsexpressspringrefactor.models.PetType;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.PetRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PetsApiController {
  @Autowired private PetRepository petRepository;

  @GetMapping("/pets")
  public Page<Pet> getPets(Pageable pageable) { return petRepository.findByAdoptionStatusFalse(pageable); }

  @GetMapping("/past-pets")
  public Page<Pet> getPastPets(Pageable pageable) { return petRepository.findByAdoptionStatusTrue(pageable); }

  @GetMapping("/classification/{grouping}")
  public Page<Pet> getPetsByClassification(@PathVariable String grouping, Pageable pageable) { return petRepository.getByClassification(grouping, pageable); }

  @GetMapping("/type/{grouping}")
  public Page<Pet> getPetsByTypes(@PathVariable String grouping, Pageable pageable) { return petRepository.getByType(grouping, pageable); }

  @GetMapping("/breed/{grouping}")
  public Page<Pet> getPetsByBreed(@PathVariable String grouping, Pageable pageable) { return petRepository.getByBreed(grouping, pageable); }

  @NoArgsConstructor
  private class PetNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class PetNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String petNotFoundHandler(PetNotFoundException ex) { return ex.getMessage(); }
  }

  @GetMapping("/pets/{petName}")
  public Pet getPetById(@PathVariable String petName) { return petRepository.findByName(petName).orElseThrow(() -> new PetNotFoundException()); }

  @PostMapping("/pets")
  public Pet createPet(@PathVariable Pet pet) { return petRepository.save(pet); }
}