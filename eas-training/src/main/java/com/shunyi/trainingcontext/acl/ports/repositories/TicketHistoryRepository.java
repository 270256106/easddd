package com.shunyi.trainingcontext.acl.ports.repositories;

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
public interface TicketHistoryRepository {
    Optional<TicketHistory> latest(TicketId ticketId);

    void add(TicketHistory ticketHistory);

    void deleteBy(TicketId ticketId);
}
