package dev.davletshin.marks.domain;

import dev.davletshin.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "groups")
@Data
@RequiredArgsConstructor
public class Group extends BaseEntity {


    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @ElementCollection
    private Set<Long> usersId;
}
