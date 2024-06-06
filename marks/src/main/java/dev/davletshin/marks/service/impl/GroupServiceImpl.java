package dev.davletshin.marks.service.impl;

import dev.davletshin.common.domain.exception.ResourceNotFoundException;
import dev.davletshin.marks.domain.Group;
import dev.davletshin.marks.repository.GroupRepository;
import dev.davletshin.marks.service.interfaces.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public Group createGroup(Group group) {
        if (groupRepository.existsByTitle(group.getTitle())) {
            throw new IllegalStateException("A group with that title already exists");
        }
        return groupRepository.save(group);
    }

    @Override
    public Group updateGroup(Group group) {
        if (groupRepository.existsByTitle(group.getTitle())) {
            throw new IllegalStateException("A group with that title already exists");
        }
        return groupRepository.save(group);
    }

    @Override
    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }

    @Override
    public Group getGroup(Long groupId) {
        return groupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("Group by id not found exception"));
    }
}
