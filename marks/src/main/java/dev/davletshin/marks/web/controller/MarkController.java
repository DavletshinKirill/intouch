package dev.davletshin.marks.web.controller;

import dev.davletshin.common.web.validation.OnCreate;
import dev.davletshin.common.web.validation.OnUpdate;
import dev.davletshin.marks.domain.Mark;
import dev.davletshin.marks.service.interfaces.MarkService;
import dev.davletshin.marks.web.DTO.MarkDTO;
import dev.davletshin.marks.web.mapper.MarkMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mark")
public class MarkController {
    private final MarkService markService;
    private final MarkMapper markMapper;

    @Operation(summary = "Delete Mark")
    @DeleteMapping("/delete/{markId}")
    public void deleteById(@PathVariable Long markId) {
        markService.deleteMark(markId);
    }

    @Operation(summary = "Update Mark")
    @PutMapping("/update")
    public MarkDTO updateMark(@Validated(OnUpdate.class)
                              @RequestBody MarkDTO markDTO) {
        Mark mark = markMapper.toEntity(markDTO);
        Mark updatedMark = markService.updateMark(mark);
        return markMapper.toDTO(updatedMark);
    }

    @Operation(summary = "Create Mark")
    @PostMapping("/create")
    public MarkDTO createMark(@Validated(OnCreate.class) @RequestBody MarkDTO markDTO) {
        Mark mark = markMapper.toEntity(markDTO);
        Mark createdMark = markService.createMark(mark);
        return markMapper.toDTO(createdMark);
    }

    @GetMapping("/get/{groupId}")
    public Set<MarkDTO> getMarks(@PathVariable Long userId, @PathVariable Long semesterId) {
        Set<Mark> marks = markService.getMarksByUserIdAndSubjectId(userId, semesterId);
        return markMapper.toDTO(marks);
    }
}
