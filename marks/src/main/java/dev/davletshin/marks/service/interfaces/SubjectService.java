package dev.davletshin.marks.service.interfaces;

import dev.davletshin.marks.domain.Subject;

import java.util.Set;

public interface SubjectService {
    Subject createSubject(Subject subject);

    Subject updateSubject(Subject subject);

    void deleteSubject(Long subjectId);

    Set<Subject> getSubjectsBySemesterId(Long semesterId, int pageNo, int pageSize);
}
