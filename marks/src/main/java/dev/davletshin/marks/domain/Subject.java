package dev.davletshin.marks.domain;

import dev.davletshin.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "subject")
@Data
@RequiredArgsConstructor
public class Subject extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "semester_id", updatable = true)
    private Semester semester;
}
