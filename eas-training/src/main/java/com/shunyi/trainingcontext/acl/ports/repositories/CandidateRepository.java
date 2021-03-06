package com.shunyi.trainingcontext.acl.ports.repositories;

import com.shunyi.ddd.core.stereotype.Adapter;
import com.shunyi.ddd.core.stereotype.PortType;
import com.shunyi.trainingcontext.domain.candidate.Candidate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhang
 */
@Mapper
@Repository
@Adapter(PortType.Repository)
public interface CandidateRepository {
    void remove(Candidate candidate);
}
