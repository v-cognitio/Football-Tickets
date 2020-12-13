package org.v_cognitio.tickets.repository;

import org.springframework.stereotype.Repository;
import org.v_cognitio.tickets.model.Subscription;

@Repository
public class DataJpaSubscriptionRepository {

    private final CrudSubscriptionRepository repository;

    public DataJpaSubscriptionRepository(CrudSubscriptionRepository repository) {
        this.repository = repository;
    }

    public Subscription save(Subscription subscription) {
        return repository.save(subscription);
    }

    public boolean delete(int id) {
        return repository.deleteById(id) != 0;
    }

    public Subscription get(int id) {
        return repository.findById(id).orElse(null);
    }
}
