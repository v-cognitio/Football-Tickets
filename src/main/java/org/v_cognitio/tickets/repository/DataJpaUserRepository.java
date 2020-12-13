package org.v_cognitio.tickets.repository;

import org.springframework.stereotype.Repository;
import org.v_cognitio.tickets.model.User;

@Repository
public class DataJpaUserRepository {

    private final CrudUserRepository repository;

    public DataJpaUserRepository(CrudUserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User get(int id) {
        return repository.findById(id).orElse(null);
    }

    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    public User getWithTickets(int id) {
        return repository.getWithTickets(id);
    }

    public boolean delete(int id) {
        return repository.deleteById(id) != 0;
    }
}
