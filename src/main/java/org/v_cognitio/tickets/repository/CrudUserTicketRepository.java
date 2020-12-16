package org.v_cognitio.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.v_cognitio.tickets.model.UserTicket;

@Transactional(readOnly = true)
public interface CrudUserTicketRepository extends JpaRepository<UserTicket, Integer> {
}
