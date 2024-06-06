package dev.davletshin.marks.repository;

import dev.davletshin.marks.domain.Semester;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
    @Query(value = """
                    SELECT * FROM semester s
                    WHERE s.group_id = :groupId
            """, nativeQuery = true)
    Page<Semester> findSemestersByGroupId(Long groupId, Pageable pageable);

    boolean existsByTitle(String title);
}
