package dev.davletshin.marks.service.interfaces;


import dev.davletshin.marks.domain.Group;

public interface GroupService {
    Group createGroup(Group group);

    Group updateGroup(Group group);

    void deleteGroup(Long groupId);

    Group getGroup(Long groupId);
}
