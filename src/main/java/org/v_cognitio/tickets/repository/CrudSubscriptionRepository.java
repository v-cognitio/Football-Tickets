package org.v_cognitio.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.v_cognitio.tickets.model.Subscription;

@Transactional(readOnly = true)
public interface CrudSubscriptionRepository extends JpaRepository<Subscription, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Subscription s WHERE s.id=:id")
    int deleteById(@Param("id") int id);
}
