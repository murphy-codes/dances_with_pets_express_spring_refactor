package com.launchacademy.danceswithpetsexpressspringrefactor.controllers;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.Pet;
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
@RequestMapping("/api/v1/pets")
public class PetsApiController {
  @Autowired private PetRepository petRepository;

  @GetMapping
  public Page<Pet> getPets(Pageable pageable) { return petRepository.findAll(pageable); }

  @NoArgsConstructor
  private class PetNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class PetNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String petNotFoundHandler(PetNotFoundException ex) { return ex.getMessage(); }
  }

  @GetMapping("/{id}")
  public Pet getPetById(@PathVariable Integer id) { return petRepository.findById(id).orElseThrow(() -> new PetNotFoundException()); }

  @PostMapping
  public Pet createPet(@PathVariable Pet pet) { return petRepository.save(pet); }
}