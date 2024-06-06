package dev.davletshin.marks.domain;

import dev.davletshin.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Table(name = "marks")
@Entity
@Data
public class Mark extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "mark", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private MarkEnum mark;

    private LocalDateTime dateTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "subject_id", updatable = true)
    private Subject subject;
}
