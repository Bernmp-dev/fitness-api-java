package com.betrybe.fitness.controller;

import com.betrybe.fitness.service.FitnessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fitness controller component.
 */
@RestController
public class FitnessController implements FitnessControllerInterface {

  @Autowired
    public FitnessController(FitnessServiceInterface fitnessService) {
  }
}
