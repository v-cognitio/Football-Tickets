package org.v_cognitio.tickets.model;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "users_unique_email_idx")
})
@Check(constraints = "(subscription IS NULL) OR (sub_expire IS NOT NULL)")
@NamedEntityGraph(name = "UserWithTickets",
        attributeNodes = {
            @NamedAttributeNode("subscription"),
            @NamedAttributeNode(value = "tickets", subgraph = "Ticket")
        },
        subgraphs = {@NamedSubgraph(name = "Ticket",
            attributeNodes = {
                //@NamedAttributeNode("user"),
                @NamedAttributeNode("ticket")
            })
        }
)
public class User extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "email", nullable = false)
    @NotBlank
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subscription")
    private Subscription subscription;

    @Column(name = "sub_expire")
    private LocalDateTime subscriptionExpire;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<UserTicket> tickets;

    public User() {

    }

    public User(Integer id,
                String name,
                String email,
                String password,
                Subscription subscription,
                LocalDateTime subscriptionExpire) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.subscription = subscription;
        this.subscriptionExpire = subscriptionExpire;
    }

    public List<UserTicket> getTickets() {
        return tickets;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public void setSubscriptionExpire(LocalDateTime subscriptionExpire) {
        this.subscriptionExpire = subscriptionExpire;
    }

    public LocalDateTime getSubscriptionExpire() {
        return subscriptionExpire;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", subscription=" + subscription +
                ", subscriptionExpire=" + subscriptionExpire +
                '}';
    }
}
