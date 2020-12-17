package org.v_cognitio.tickets.repository;

import org.springframework.stereotype.Repository;
import org.v_cognitio.tickets.model.UserTicket;

@Repository
public class DataJpaUserTicketRepository {

    private final CrudUserTicketRepository repository;

    public DataJpaUserTicketRepository(CrudUserTicketRepository repository) {
        this.repository = repository;
    }

    public UserTicket save(UserTicket userTicket) {
        return repository.save(userTicket);
    }

    public boolean delete(int id) {
        return repository.deleteById(id) != 0;
    }
}
