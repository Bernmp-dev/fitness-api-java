package com.betrybe.fitness.service;

import com.betrybe.fitness.database.FakeFitnessDatabase;
import com.betrybe.fitness.dto.WorkoutCreationDto;
import com.betrybe.fitness.dto.WorkoutDto;
import com.betrybe.fitness.model.Workout;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fitness service component.
 */
@Service
public class FitnessService implements FitnessServiceInterface {

  private final FakeFitnessDatabase repository;

  @Autowired
  public FitnessService(FakeFitnessDatabase repository) {
    this.repository = repository;
  }

  @Override
  public WorkoutDto saveWorkout(WorkoutCreationDto newWorkoutDto) {
    return null;
  }

  @Override
  public Optional<WorkoutDto> getWorkout(Long id) {
    Optional<Workout> workout = repository.getWorkout(id);

    return workout.map(value -> new WorkoutDto(
        value.getId(),
        value.getName(),
        value.getRepetitions()
    ));

  }

  @Override
  public List<WorkoutDto> getAllWorkouts() {
    return null;
  }
}
