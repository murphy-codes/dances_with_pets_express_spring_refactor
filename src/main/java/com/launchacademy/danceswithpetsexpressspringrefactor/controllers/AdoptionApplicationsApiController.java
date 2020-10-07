package com.launchacademy.danceswithpetsexpressspringrefactor.controllers;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.AdoptionApplication;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.AdoptionApplicationRepository;
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
@RequestMapping("/api/v1/adoption-applications")
public class AdoptionApplicationsApiController {
  @Autowired private AdoptionApplicationRepository adoptionApplicationRepository;

  @GetMapping
  public Page<AdoptionApplication> getAdoptionApplications(Pageable pageable) { return adoptionApplicationRepository.findAll(pageable); }

  @NoArgsConstructor
  private class AdoptionApplicationNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class AdoptionApplicationNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AdoptionApplicationsApiController.AdoptionApplicationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String adoptionApplicationNotFoundHandler(AdoptionApplicationsApiController.AdoptionApplicationNotFoundException ex) { return ex.getMessage(); }
  }

  @GetMapping("/{id}")
  public AdoptionApplication getAdoptionApplicationById(@PathVariable Integer id) { return adoptionApplicationRepository.findById(id).orElseThrow(() -> new AdoptionApplicationsApiController.AdoptionApplicationNotFoundException()); }

  @PostMapping
  public AdoptionApplication createAdoptionApplication(@PathVariable AdoptionApplication adoptionApplication) { return adoptionApplicationRepository.save(adoptionApplication); }
}
