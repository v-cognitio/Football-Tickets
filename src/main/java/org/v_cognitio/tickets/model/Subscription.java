package org.v_cognitio.tickets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subscriptions")
public class Subscription extends BaseEntity {

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @Column(name = "discount", nullable = false)
    @NotNull
    private Integer discount;

    public Subscription() {

    }

    public Subscription(Integer id, String description, Integer discount) {
        super(id);
        this.description = description;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                '}';
    }
}
