package dev.davletshin.marks.repository;

import dev.davletshin.marks.domain.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    @Query(value = """
                    SELECT * FROM marks m
                    WHERE m.user_id = :userId AND m.subject_id = :subjectId
            """, nativeQuery = true)
    Optional<Set<Mark>> findMarksByUserIdAndSubjectId(Long userId, Long subjectId);
}
