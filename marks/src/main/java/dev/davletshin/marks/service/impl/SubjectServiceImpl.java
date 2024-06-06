package dev.davletshin.marks.service.impl;

import dev.davletshin.marks.domain.Subject;
import dev.davletshin.marks.repository.SubjectRepository;
import dev.davletshin.marks.service.interfaces.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Override
    public Subject createSubject(Subject subject) {
        if (subjectRepository.existsSubjectsBySemesterIdAndTitle(subject.getSemester().getId(), subject.getTitle())) {
            throw new IllegalStateException("A subject with that title already exists in  this semester");
        }
        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(Subject subject) {
        if (subjectRepository.existsSubjectsBySemesterIdAndTitle(subject.getSemester().getId(), subject.getTitle())) {
            throw new IllegalStateException("A subject with that title already exists in  this semester");
        }
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }

    @Override
    public Set<Subject> getSubjectsBySemesterId(Long semesterId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Subject> semesterPage = subjectRepository.findSubjectsBySemesterId(semesterId, pageable);
        return semesterPage.hasContent() ? new HashSet<>(semesterPage.getContent()) : Collections.emptySet();
    }
}
