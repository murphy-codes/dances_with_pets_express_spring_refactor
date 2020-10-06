package com.launchacademy.danceswithpetsexpressspringrefactor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
  @GetMapping(value = "/**/{path:[^\\.]*}")
  public String forward() { return "forward:/"; }
}