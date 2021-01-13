package com.shunyi.trainingcontext.acl.ports.repositories;

import com.shunyi.trainingcontext.domain.ticket.Ticket;
import com.shunyi.trainingcontext.domain.ticket.TicketId;
import com.shunyi.trainingcontext.domain.ticket.TicketService;
import com.shunyi.trainingcontext.domain.ticket.TicketStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author zhang
 */
@Mapper
@Repository
public interface TicketRepository {
    Optional<Ticket> ticketOf(TicketId ticketId, TicketStatus ticketStatus);

    void update(Ticket ticket);

    void add(Ticket ticket);

    void remove(Ticket ticket);
}
