package org.v_cognitio.tickets.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class BaseEntity implements Persistable<Integer> {

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 100000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    protected BaseEntity() {

    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }
}
