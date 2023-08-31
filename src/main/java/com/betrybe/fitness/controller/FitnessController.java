package com.betrybe.fitness.controller;

import com.betrybe.fitness.dto.WorkoutDto;
import com.betrybe.fitness.service.FitnessServiceInterface;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Fitness controller component.
 */
@RestController
public class FitnessController implements FitnessControllerInterface {

  private final FitnessServiceInterface fitnessService;
  
  @Autowired
    public FitnessController(FitnessServiceInterface fitnessService) {
    this.fitnessService = fitnessService;
  }

  @GetMapping("/fitness")
  public String getFitness() {
    return "Boas vindas à API de Fitness!";
  }

  /**
   * Get workout by id.
   *
   * @param id workout id
   * @return workout
   */
  @GetMapping("/fitness/workouts/{id}")
  public ResponseEntity<WorkoutDto> getWorkoutById(@PathVariable Long id) {
    Optional<WorkoutDto> result = fitnessService.getWorkout(id);

    if (result.isPresent()) {
      return ResponseEntity.ok(result.get());
    }

    return ResponseEntity.notFound().build();
  }
}
