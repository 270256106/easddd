package com.shunyi.trainingcontext.acl.ports.repositories;

import com.shunyi.trainingcontext.domain.course.CourseId;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhang
 * @create 2021-01-12 10:55
 */
@Mapper
@Repository
public interface LearningRepository {
    boolean exists(String traineeId, CourseId courseId);
}