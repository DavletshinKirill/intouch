package dev.davletshin.marks.service.interfaces;

import dev.davletshin.marks.domain.Mark;

import java.util.Set;

public interface MarkService {
    Mark createMark(Mark mark);

    Mark updateMark(Mark mark);

    void deleteMark(Long markId);

    Set<Mark> getMarksByUserIdAndSubjectId(Long userId, Long subjectId);
}
