package org.v_cognitio.tickets;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.v_cognitio.tickets.model.Subscription;
import org.v_cognitio.tickets.model.Ticket;
import org.v_cognitio.tickets.model.User;
import org.v_cognitio.tickets.repository.DataJpaSubscriptionRepository;
import org.v_cognitio.tickets.repository.DataJpaTicketRepository;
import org.v_cognitio.tickets.repository.DataJpaUserRepository;

import java.time.LocalDateTime;

public class SpringMain {

    public static void main(String[] args) {
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-db.xml");
            appCtx.refresh();

            DataJpaUserRepository repository = appCtx.getBean(DataJpaUserRepository.class);
            repository.delete(100002);
            System.out.println("");
        }
    }
}
