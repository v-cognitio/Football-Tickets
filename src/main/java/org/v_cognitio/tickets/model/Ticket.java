package org.v_cognitio.tickets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity{

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "price", nullable = false)
    @NotNull
    private Float price;

    public Ticket() {

    }

    public Ticket(Integer id, String description, LocalDateTime dateTime, Float price) {
        super(id);
        this.description = description;
        this.dateTime = dateTime;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", price=" + price +
                '}';
    }
}
