package com.launchacademy.danceswithpetsexpressspringrefactor.controllers;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.PetType;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.PetTypeRepository;
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
@RequestMapping("/api/v1/pet-types")
public class PetTypesApiController {
  @Autowired private PetTypeRepository petTypeRepository;

  @GetMapping
  public Page<PetType> getPetTypes(Pageable pageable) { return petTypeRepository.findAll(pageable); }

  @NoArgsConstructor
  private class PetTypeNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class PetTypeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PetTypesApiController.PetTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String petTypeNotFoundHandler(PetTypesApiController.PetTypeNotFoundException ex) { return ex.getMessage(); }
  }

  @GetMapping("/{id}")
  public PetType getPetTypeById(@PathVariable Integer id) { return petTypeRepository.findById(id).orElseThrow(() -> new PetTypesApiController.PetTypeNotFoundException()); }

  @PostMapping
  public PetType createPetType(@PathVariable PetType petType) { return petTypeRepository.save(petType); }
}