package dev.davletshin.marks.repository;

import dev.davletshin.marks.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    boolean existsByTitle(String title);
}
