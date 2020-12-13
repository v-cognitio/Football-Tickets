package org.v_cognitio.tickets.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_tickets")
public class UserTicket extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Ticket ticket;

    @Column(name = "cost", nullable = false)
    @NotNull
    private Float cost;

    public UserTicket() {

    }

    public UserTicket(Integer id, User user, Ticket ticket, Float cost) {
        super(id);
        this.user = user;
        this.ticket = ticket;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "UserTicket{" +
                "id=" + id +
                ", user=" + user +
                ", ticket=" + ticket +
                ", cost=" + cost +
                "} " + super.toString();
    }
}
