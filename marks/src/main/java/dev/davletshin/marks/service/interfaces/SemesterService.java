package dev.davletshin.marks.service.interfaces;

import dev.davletshin.marks.domain.Semester;

import java.util.Set;

public interface SemesterService {
    Semester createSemester(Semester semester);

    Semester updateSemester(Semester semester);

    void deleteSemester(Long semesterId);

    Set<Semester> getSemestersByGroupId(Long groupId, int pageNo, int pageSize);
}
