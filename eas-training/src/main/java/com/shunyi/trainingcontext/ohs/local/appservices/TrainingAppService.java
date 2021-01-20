package com.shunyi.trainingcontext.ohs.local.appservices;

import com.google.common.base.Strings;
import com.shunyi.ddd.core.exceptions.ApplicationDomainException;
import com.shunyi.ddd.core.exceptions.ApplicationInfrastructureException;
import com.shunyi.ddd.core.exceptions.ApplicationValidationException;
import com.shunyi.ddd.core.exceptions.DomainException;
import com.shunyi.ddd.core.stereotype.Local;
import com.shunyi.trainingcontext.domain.training.Training;
import com.shunyi.trainingcontext.domain.training.TrainingId;
import com.shunyi.trainingcontext.domain.training.TrainingService;
import com.shunyi.trainingcontext.ohs.local.pl.TrainingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhang
 * @create 2021-01-12 17:54
 */
@Service
@Local
public class TrainingAppService {

    @Autowired
    private TrainingService trainingService;

    public TrainingResponse trainingOf(String trainingId) {
        if (Strings.isNullOrEmpty(trainingId)) {
            throw new ApplicationValidationException("TrainingId can not be null or empty");
        }
        try {
            Training training = trainingService.trainingOf(TrainingId.from(trainingId));
            // todo: fetch the course detail by training.courseId() by CourseService;
            return TrainingResponse.from(training);
        } catch (DomainException ex) {
            throw new ApplicationDomainException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ApplicationInfrastructureException(ex.getMessage(), ex);
        }
    }
}