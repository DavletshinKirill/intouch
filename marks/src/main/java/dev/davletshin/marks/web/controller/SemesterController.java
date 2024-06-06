package dev.davletshin.marks.web.controller;

import dev.davletshin.common.web.validation.OnCreate;
import dev.davletshin.common.web.validation.OnUpdate;
import dev.davletshin.marks.domain.Semester;
import dev.davletshin.marks.service.interfaces.SemesterService;
import dev.davletshin.marks.web.DTO.SemesterDTO;
import dev.davletshin.marks.web.mapper.SemesterMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/semester")
public class SemesterController {
    private final SemesterService semesterService;
    private final SemesterMapper semesterMapper;


    @Operation(summary = "Delete Semester")
    @DeleteMapping("/delete/{semesterId}")
    public void deleteById(@PathVariable Long semesterId) {
        semesterService.deleteSemester(semesterId);
    }

    @Operation(summary = "Update Semester")
    @PutMapping("/update")
    public SemesterDTO updateSemester(@Validated(OnUpdate.class)
                                      @RequestBody SemesterDTO semesterDTO) {
        Semester semester = semesterMapper.toEntity(semesterDTO);
        Semester updatedSemester = semesterService.updateSemester(semester);
        return semesterMapper.toDTO(updatedSemester);
    }

    @Operation(summary = "Create Semester")
    @PostMapping("/create")
    public SemesterDTO createSemester(@Validated(OnCreate.class) @RequestBody SemesterDTO semesterDTO) {
        Semester semester = semesterMapper.toEntity(semesterDTO);
        Semester createdSemester = semesterService.createSemester(semester);
        return semesterMapper.toDTO(createdSemester);
    }

    @Operation(summary = "Get Semesters")
    @GetMapping("/get/{group_id}")
    public Set<SemesterDTO> getSemester(@PathVariable Long group_id,
                                        @RequestParam(defaultValue = "0") int pageNo,
                                        @RequestParam(defaultValue = "10") int pageSize) {
        Set<Semester> semesterSet = semesterService.getSemestersByGroupId(group_id, pageNo, pageSize);
        return semesterMapper.toDTO(semesterSet);
    }
}
