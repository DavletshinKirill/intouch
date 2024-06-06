package dev.davletshin.marks.repository;

import dev.davletshin.marks.domain.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query(value = """
                    SELECT * FROM subject s
                    WHERE s.semester_id = :semesterId
            """, nativeQuery = true)
    Page<Subject> findSubjectsBySemesterId(Long semesterId, Pageable pageable);

    @Query(value = """
    SELECT CASE WHEN COUNT(s) > 0 THEN 
    true ELSE false END FROM Subject s WHERE s.semester_id = :semesterId AND s.title = :title
    """, nativeQuery = true)
    boolean existsSubjectsBySemesterIdAndTitle(Long semesterId, String title);

}
