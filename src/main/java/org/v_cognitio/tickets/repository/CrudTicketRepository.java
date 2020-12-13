package org.v_cognitio.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.v_cognitio.tickets.model.Ticket;

@Transactional(readOnly = true)
public interface CrudTicketRepository extends JpaRepository<Ticket, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Ticket t WHERE t.id=:id")
    int deleteById(@Param("id") int id);

}
