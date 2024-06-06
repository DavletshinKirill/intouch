package dev.davletshin.marks.web.controller;

import dev.davletshin.common.web.validation.OnCreate;
import dev.davletshin.common.web.validation.OnUpdate;
import dev.davletshin.marks.domain.Subject;
import dev.davletshin.marks.service.interfaces.SubjectService;
import dev.davletshin.marks.web.DTO.SubjectDTO;
import dev.davletshin.marks.web.mapper.SubjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/subject")
public class SubjectController {
    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    @Operation(summary = "Delete Subject")
    @DeleteMapping("/delete/{subjectId}")
    public void deleteById(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
    }

    @Operation(summary = "Update Subject")
    @PutMapping("/update")
    public SubjectDTO updateSubject(@Validated(OnUpdate.class)
                                    @RequestBody SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.toEntity(subjectDTO);
        Subject updatedSubject = subjectService.updateSubject(subject);
        return subjectMapper.toDTO(updatedSubject);
    }

    @Operation(summary = "Create Subject")
    @PostMapping("/create")
    public SubjectDTO createSubject(@Validated(OnCreate.class) @RequestBody SubjectDTO subjectDTO) {
        Subject subject = subjectMapper.toEntity(subjectDTO);
        Subject updatedSubject = subjectService.createSubject(subject);
        return subjectMapper.toDTO(updatedSubject);
    }

    @Operation(summary = "Get Subjects")
    @GetMapping("/get/{semester_id}")
    public Set<SubjectDTO> getSubjects(@PathVariable Long semester_id,
                                       @RequestParam(defaultValue = "0") int pageNo,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        Set<Subject> semesterSet = subjectService.getSubjectsBySemesterId(semester_id, pageNo, pageSize);
        return subjectMapper.toDTO(semesterSet);
    }
}
