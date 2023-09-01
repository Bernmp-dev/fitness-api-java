package com.betrybe.fitness.controller;

import com.betrybe.fitness.dto.WorkoutCreationDto;
import com.betrybe.fitness.dto.WorkoutDto;
import com.betrybe.fitness.service.FitnessServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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
   * Get all workouts.
   *
   * @return list of workouts
   */
  @GetMapping("/fitness/workouts")
  public ResponseEntity<List<WorkoutDto>> getAllWorkouts() {
    List<WorkoutDto> result = fitnessService.getAllWorkouts();

    if (result != null) {
      return ResponseEntity.ok(result);
    }

    return ResponseEntity.notFound().build();
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

  /**
   * Save workout.
   *
   * @param workout workout
   * @return saved workout
   */
  @PostMapping("/fitness/workouts")
  public ResponseEntity<WorkoutDto> saveWorkout(@RequestBody WorkoutCreationDto workout) {

    WorkoutDto result = fitnessService.saveWorkout(workout);
    return ResponseEntity.status(201).body(result);
  }
}
