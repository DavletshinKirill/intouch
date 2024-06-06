package dev.davletshin.marks.service.impl;

import dev.davletshin.common.domain.exception.ResourceNotFoundException;
import dev.davletshin.marks.domain.Mark;
import dev.davletshin.marks.repository.MarkRepository;
import dev.davletshin.marks.service.interfaces.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;

    @Override
    public Mark createMark(Mark mark) {
        mark.setDateTime(LocalDateTime.now());
        return markRepository.save(mark);
    }

    @Override
    public Mark updateMark(Mark mark) {
        mark.setDateTime(LocalDateTime.now());
        return markRepository.save(mark);
    }

    @Override
    public void deleteMark(Long markId) {
        markRepository.deleteById(markId);
    }

    @Override
    public Set<Mark> getMarksByUserIdAndSubjectId(Long userId, Long subjectId) {
        return markRepository.findMarksByUserIdAndSubjectId(userId, subjectId).orElseThrow(
                () -> new ResourceNotFoundException("Marks by userId and subjectId not found exception")
        );
    }

}
