package dev.davletshin.marks.domain;

import dev.davletshin.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "semester")
@Data
public class Semester extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "groups_id", updatable = true)
    private Group group;
}
