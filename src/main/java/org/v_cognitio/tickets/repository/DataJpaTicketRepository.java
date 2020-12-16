package org.v_cognitio.tickets.repository;

import org.springframework.stereotype.Repository;
import org.v_cognitio.tickets.model.Ticket;

import java.util.List;

@Repository
public class DataJpaTicketRepository {

    private final CrudTicketRepository repository;

    public DataJpaTicketRepository(CrudTicketRepository repository) {
        this.repository = repository;
    }

    public Ticket save(Ticket ticket) {
        return repository.save(ticket);
    }

    public boolean delete(int id) {
        return repository.deleteById(id) != 0;
    }

    public Ticket get(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Ticket> getAll() {
        return repository.findAll();
    }
}
