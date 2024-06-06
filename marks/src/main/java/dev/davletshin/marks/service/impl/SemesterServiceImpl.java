package dev.davletshin.marks.service.impl;

import dev.davletshin.marks.domain.Semester;
import dev.davletshin.marks.repository.SemesterRepository;
import dev.davletshin.marks.service.interfaces.SemesterService;
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
public class SemesterServiceImpl implements SemesterService {
    private final SemesterRepository semesterRepository;

    @Override
    public Semester createSemester(Semester semester) {
        if (semesterRepository.existsByTitle(semester.getTitle())) {
            throw new IllegalStateException("A semester with that title already exists");
        }
        return semesterRepository.save(semester);
    }

    @Override
    public Semester updateSemester(Semester semester) {
        if (semesterRepository.existsByTitle(semester.getTitle())) {
            throw new IllegalStateException("A semester with that title already exists");
        }
        return semesterRepository.save(semester);
    }

    @Override
    public void deleteSemester(Long semesterId) {
        semesterRepository.deleteById(semesterId);
    }

    @Override
    public Set<Semester> getSemestersByGroupId(Long groupId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Semester> semesterPage = semesterRepository.findSemestersByGroupId(groupId, pageable);
        return semesterPage.hasContent() ? new HashSet<>(semesterPage.getContent()) : Collections.emptySet();
    }

}
