package com.launchacademy.danceswithpetsexpressspringrefactor.controllers;

import com.launchacademy.danceswithpetsexpressspringrefactor.models.SurrenderApplication;
import com.launchacademy.danceswithpetsexpressspringrefactor.repositories.SurrenderApplicationRepository;
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
@RequestMapping("/api/v1/surrender-applications")
public class SurrenderApplicationsApiController {
  @Autowired private SurrenderApplicationRepository surrenderApplicationRepository;

  @GetMapping
  public Page<SurrenderApplication> getSurrenderApplications(Pageable pageable) { return surrenderApplicationRepository.findAll(pageable); }

  @NoArgsConstructor
  private class SurrenderApplicationNotFoundException extends RuntimeException {};

  @ControllerAdvice
  private class SurrenderApplicationNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(SurrenderApplicationsApiController.SurrenderApplicationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String surrenderApplicationNotFoundHandler(SurrenderApplicationsApiController.SurrenderApplicationNotFoundException ex) { return ex.getMessage(); }
  }

  @GetMapping("/{id}")
  public SurrenderApplication getSurrenderApplicationById(@PathVariable Integer id) { return surrenderApplicationRepository.findById(id).orElseThrow(() -> new SurrenderApplicationsApiController.SurrenderApplicationNotFoundException()); }

  @PostMapping
  public SurrenderApplication createSurrenderApplication(@PathVariable SurrenderApplication surrenderApplication) { return surrenderApplicationRepository.save(surrenderApplication); }
}
