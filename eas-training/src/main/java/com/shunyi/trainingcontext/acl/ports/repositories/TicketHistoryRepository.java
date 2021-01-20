package com.shunyi.trainingcontext.acl.ports.repositories;

import com.shunyi.ddd.core.stereotype.Adapter;
import com.shunyi.ddd.core.stereotype.PortType;
import com.shunyi.trainingcontext.domain.ticket.TicketId;
import com.shunyi.trainingcontext.domain.tickethistory.TicketHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author zhang
 */
@Mapper
@Repository
@Adapter(PortType.Repository)
public interface TicketHistoryRepository {
    Optional<TicketHistory> latest(TicketId ticketId);

    void add(TicketHistory ticketHistory);

    void deleteBy(TicketId ticketId);
}
