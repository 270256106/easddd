package com.shunyi.trainingcontext.domain.leaning;

import com.shunyi.ddd.core.stereotype.Aggregate;
import com.shunyi.trainingcontext.domain.course.CourseId;
import com.shunyi.trainingcontext.domain.training.TrainingId;

/**
 * @author zhang
 * @create 2021-01-12 14:59
 */
@Aggregate
public class Learning {
    private String     learningId;
    private CourseId   courseId;
    private TrainingId trainingId;
    private String     traineeId;

    public Learning(String learningId, CourseId courseId, TrainingId trainingId, String traineeId) {
        this.learningId = learningId;
        this.courseId = courseId;
        this.trainingId = trainingId;
        this.traineeId = traineeId;
    }
}