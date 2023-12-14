package com.yasser.managefile.service;

import com.yasser.managefile.model.File;
import com.yasser.managefile.model.Item;
import com.yasser.managefile.model.Permission;
import com.yasser.managefile.model.PermissionGroup;
import com.yasser.managefile.model.lockup.ItemType;
import com.yasser.managefile.model.lockup.PermissionLevel;
import com.yasser.managefile.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private final PermissionService permissionService;

    private final FileService fileService;

    public ItemService(ItemRepository itemRepository, PermissionService permissionService, FileService fileService) {
        this.itemRepository = itemRepository;
        this.permissionService = permissionService;
        this.fileService = fileService;
    }

    public Item createSpace(String spaceName, String permissionGroupName, String viewUserEmail, String editUserEmail) {
        // Create Space
        Item space = new Item();
        space.setItemType(ItemType.SPACE);
        space.setName(spaceName);
        itemRepository.save(space);

        // Create Permission Group
        PermissionGroup permissionGroup = new PermissionGroup();
        permissionGroup.setName(permissionGroupName);
        permissionGroup = permissionService.createPermissionGroup(permissionGroup);

        // Assign VIEW permission
        Permission viewPermission = new Permission();
        viewPermission.setUserEmail(viewUserEmail);
        viewPermission.setPermissionLevel(PermissionLevel.VIEW);
        viewPermission.setPermissionGroup(permissionGroup);
        permissionService.createPermission(viewPermission);

        // Assign EDIT permission
        Permission editPermission = new Permission();
        editPermission.setUserEmail(editUserEmail);
        editPermission.setPermissionLevel(PermissionLevel.EDIT);
        editPermission.setPermissionGroup(permissionGroup);
        permissionService.createPermission(editPermission);

        // Assign the permission group to the space
        space.setPermissionGroup(permissionGroup);
        itemRepository.save(space);

        return space;
    }

    public Item createFolder(Long parentId, String folderName, String userWithEditAccessEmail) throws Exception {
        // Check if the parent exists and is a space or folder
        Item parent = itemRepository.findById(parentId)
                .orElseThrow(() -> new EntityNotFoundException("Parent item not found"));

        if (!ItemType.SPACE.equals(parent.getItemType()) && !ItemType.FOLDER.equals(parent.getItemType())) {
            throw new IllegalArgumentException("Parent item must be a space or folder");
        }

        // Check if the user has EDIT access to the parent
        if (!permissionService.hasEditAccess(parent.getPermissionGroup().getId(), userWithEditAccessEmail)) {
            throw new AccessDeniedException("User does not have EDIT access to the parent");
        }

        // Create Folder
        Item folder = new Item();
        folder.setItemType(ItemType.FOLDER);
        folder.setName(folderName);
        folder.setParent(parent);
        itemRepository.save(folder);

        return folder;
    }

    public File createFile(Long parentId, String fileName, byte[] fileContent, String userWithEditAccessEmail) throws Exception {
        // Check if the parent exists and is a folder
        Item parent = itemRepository.findById(parentId)
                .orElseThrow(() -> new EntityNotFoundException("Parent not found"));

        if (!ItemType.SPACE.equals(parent.getItemType()) && !ItemType.FOLDER.equals(parent.getItemType())) {
            throw new IllegalArgumentException("Parent item must be a space or folder");
        }

        // Check if the user has EDIT access to the parent folder
        if (!permissionService.hasEditAccess(parent.getPermissionGroup().getId(), userWithEditAccessEmail)) {
            throw new AccessDeniedException("User does not have EDIT access to the parent folder");
        }

        // Create File
        Item itemFile = new Item();
        itemFile.setItemType(ItemType.FILE);
        itemFile.setName(fileName);
        itemFile.setParent(parent);

        itemRepository.save(itemFile);

        File file = new File();
        file.setBinary(fileContent);
        file.setItem(itemFile);
        fileService.createFile(file);

        return file;
    }


}
