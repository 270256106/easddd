package com.shunyi.trainingcontext.domain.training;

import com.shunyi.ddd.core.stereotype.Aggregate;
import com.shunyi.trainingcontext.domain.course.CourseId;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author zhang
 * @create 2021-01-11 16:24
 */
@Aggregate
public class Training {
    private TrainingId    id;
    private String        title;
    private String        description;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private String        place;
    private CourseId      courseId;

    public Training(String title, String description, LocalDateTime beginTime, LocalDateTime endTime, String place, CourseId courseId) {
        this(TrainingId.from(UUID.randomUUID().toString()), title, description, beginTime, endTime, place, courseId);
    }

    public Training(TrainingId id, String title, String description, LocalDateTime beginTime, LocalDateTime endTime, String place, CourseId courseId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.place = place;
        this.courseId = courseId;
    }

    public TrainingId id() {
        return this.id;
    }

    public String title() {
        return this.title;
    }

    public String description() {
        return this.description;
    }

    public LocalDateTime beginTime() {
        return this.beginTime;
    }

    public LocalDateTime endTime() {
        return this.endTime;
    }

    public String place() {
        return this.place;
    }

    public CourseId courseId() {
        return this.courseId;
    }
}