package com.shunyi.trainingcontext.domain.training;

import com.shunyi.trainingcontext.acl.ports.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author zhang
 * @create 2021-01-11 18:00
 */
public class TrainingService {
    @Autowired
    private TrainingRepository trainingRepository;

    public Training trainingOf(TrainingId trainingId) {
        Optional<Training> optionalTraining = trainingRepository.trainingOf(trainingId);
        return optionalTraining.orElseThrow(() -> trainingNotFoundError(trainingId));
    }

    private TrainingException trainingNotFoundError(TrainingId trainingId) {
        return new TrainingException(String.format("training by id {%s} is not found.", trainingId));
    }

    public void setTrainingRepository(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }
}