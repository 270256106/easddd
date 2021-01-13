package com.shunyi.trainingcontext.domain.leaming;

import com.shunyi.trainingcontext.domain.course.CourseId;
import com.shunyi.trainingcontext.domain.training.Training;

/**
 * @author zhang
 * @create 2021-01-12 14:59
 */
public class Learning {
    private String   learningId;
    private CourseId courseId;
    private Training training;
    private String   traineeId;

    public Learning(String learningId, CourseId courseId, Training training, String traineeId) {
        this.learningId = learningId;
        this.courseId = courseId;
        this.training = training;
        this.traineeId = traineeId;
    }
}