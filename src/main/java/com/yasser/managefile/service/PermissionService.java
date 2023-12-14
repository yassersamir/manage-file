package com.yasser.managefile.service;

import com.yasser.managefile.model.Permission;
import com.yasser.managefile.model.PermissionGroup;
import com.yasser.managefile.model.lockup.PermissionLevel;
import com.yasser.managefile.repository.PermissionGroupRepository;
import com.yasser.managefile.repository.PermissionRepository;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    private final PermissionGroupRepository permissionGroupRepository;

    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionGroupRepository permissionGroupRepository, PermissionRepository permissionRepository) {
        this.permissionGroupRepository = permissionGroupRepository;
        this.permissionRepository = permissionRepository;
    }

    public PermissionGroup createPermissionGroup(PermissionGroup permissionGroup) {
        return permissionGroupRepository.save(permissionGroup);
    }

    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public boolean hasEditAccess(Long permissionGroupId, String userEmail) {
        PermissionLevel permissionLevel = PermissionLevel.EDIT;
        return permissionRepository.existsByPermissionGroup_IdAndUserEmailAndPermissionLevel(permissionGroupId, userEmail, permissionLevel);
    }
}
