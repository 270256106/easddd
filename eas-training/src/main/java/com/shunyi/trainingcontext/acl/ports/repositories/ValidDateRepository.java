package com.shunyi.trainingcontext.acl.ports.repositories;

import com.shunyi.ddd.core.stereotype.Adapter;
import com.shunyi.ddd.core.stereotype.PortType;
import com.shunyi.trainingcontext.domain.training.TrainingId;
import com.shunyi.trainingcontext.domain.validdate.ValidDate;
import com.shunyi.trainingcontext.domain.validdate.ValidDateType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
@Adapter(PortType.Repository)
public interface ValidDateRepository {
    Optional<ValidDate> validDateOf(TrainingId trainingId, ValidDateType validDateType);

    void add(ValidDate validDate);

    void remove(ValidDate validDate);
}
