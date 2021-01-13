package com.shunyi.trainingcontext.domain.leaming;

import com.shunyi.trainingcontext.acl.ports.repositories.LearningRepository;
import com.shunyi.trainingcontext.acl.ports.repositories.TrainingRepository;
import com.shunyi.trainingcontext.domain.training.Training;
import com.shunyi.trainingcontext.domain.training.TrainingException;
import com.shunyi.trainingcontext.domain.training.TrainingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zhang
 * @create 2021-01-12 14:59
 */
@Service
public class LearningService {
    @Autowired
    private TrainingRepository trainingRepo;
    @Autowired
    private LearningRepository learningRepo;

    public void setRepositoryRepo(TrainingRepository trainingRepo) {
        this.trainingRepo = trainingRepo;
    }

    public void setLearningRepo(LearningRepository learningRepo) {
        this.learningRepo = learningRepo;
    }

    public boolean beLearned(String traineeId, TrainingId trainingId) {
        Optional<Training> optionalTraining = trainingRepo.trainingOf(trainingId);
        if (!optionalTraining.isPresent()) {
            throw new TrainingException(String.format("training by id {%s} can not be found.", trainingId));
        }
        Training training = optionalTraining.get();
        return learningRepo.exists(traineeId, training.courseId());
    }
}