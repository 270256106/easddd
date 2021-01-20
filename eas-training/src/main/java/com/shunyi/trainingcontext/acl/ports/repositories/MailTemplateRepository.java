package com.shunyi.trainingcontext.acl.ports.repositories;

import com.shunyi.ddd.core.stereotype.Adapter;
import com.shunyi.ddd.core.stereotype.PortType;
import com.shunyi.trainingcontext.domain.notification.MailTemplate;
import com.shunyi.trainingcontext.domain.notification.TemplateType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author zhang
 */
@Mapper
@Repository
@Adapter(PortType.Repository)
public interface MailTemplateRepository {
    Optional<MailTemplate> templateOf(TemplateType templateType);
}
