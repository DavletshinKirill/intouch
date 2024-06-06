package dev.davletshin.marks.web.controller;

import dev.davletshin.common.web.validation.OnCreate;
import dev.davletshin.common.web.validation.OnUpdate;
import dev.davletshin.marks.domain.Group;
import dev.davletshin.marks.service.interfaces.GroupService;
import dev.davletshin.marks.web.DTO.GroupDTO;
import dev.davletshin.marks.web.mapper.GroupMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/group")
public class GroupController {
    private final GroupService groupService;
    private final GroupMapper groupMapper;

    @GetMapping("/get/{groupId}")
    public GroupDTO getGroup(@PathVariable Long groupId) {
        Group group = groupService.getGroup(groupId);
        return groupMapper.toDTO(group);
    }

    @Operation(summary = "Delete Post")
    @DeleteMapping("/delete")
    public void deleteById(@PathVariable Long groupId) {
        groupService.deleteGroup(groupId);
    }

    @Operation(summary = "Update Group")
    @PutMapping("/update")
    public GroupDTO updateGroup(@Validated(OnUpdate.class)
                                @RequestBody GroupDTO groupDTO) {
        Group group = groupMapper.toEntity(groupDTO);
        Group updatedPost = groupService.updateGroup(group);
        return groupMapper.toDTO(updatedPost);
    }

    @Operation(summary = "Create Group")
    @PostMapping("/create")
    public GroupDTO createGroup(@Validated(OnCreate.class) @RequestBody GroupDTO groupDTO) {
        Group group = groupMapper.toEntity(groupDTO);
        Group createdGroup = groupService.createGroup(group);
        return groupMapper.toDTO(createdGroup);
    }
}
