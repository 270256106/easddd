package com.shunyi.trainingcontext.acl.ports.repositories;

import com.shunyi.ddd.core.stereotype.Adapter;
import com.shunyi.ddd.core.stereotype.PortType;
import com.shunyi.trainingcontext.domain.training.Training;
import com.shunyi.trainingcontext.domain.training.TrainingId;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author zhang
 */
@Mapper
@Repository
@Adapter(PortType.Repository)
public interface TrainingRepository {

    Optional<Training> trainingOf(TrainingId trainingId);

    void add(Training training);

    void remove(Training training);
}
