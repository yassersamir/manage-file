package com.yasser.managefile.repository;

import com.yasser.managefile.model.Permission;
import com.yasser.managefile.model.lockup.PermissionLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
    boolean existsByPermissionGroup_IdAndUserEmailAndPermissionLevel(
            Long permissionGroupId, String userEmail, PermissionLevel permissionLevel);
}
