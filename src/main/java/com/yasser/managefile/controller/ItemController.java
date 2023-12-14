package com.yasser.managefile.controller;

import com.yasser.managefile.dto.request.CreateFileRequest;
import com.yasser.managefile.dto.request.CreateFolderRequest;
import com.yasser.managefile.dto.request.CreateSpaceRequest;
import com.yasser.managefile.model.File;
import com.yasser.managefile.model.Item;
import com.yasser.managefile.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/space")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create-space")
    public ResponseEntity<Item> createSpace(@RequestBody CreateSpaceRequest request) {
        //user permission should be handel by spring security but i but it in request for simplicity
        Item space = itemService.createSpace(request.getSpaceName(), request.getPermissionGroupName(), request.getViewUserEmail(), request.getEditUserEmail());
        //response should be DTO object but return entity for simplicity
        return new ResponseEntity<>(space, HttpStatus.CREATED);
    }

    @PostMapping("/create-folder")
    public ResponseEntity<Item> createFolder(@RequestBody CreateFolderRequest request) throws Exception {
        //user permission should be handel by spring security but i but it in request for simplicity
        Item folder = itemService.createFolder(request.getParentId(), request.getFolderName(), request.getUserWithEditAccessEmail());
        //response should be DTO object but return entity for simplicity
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

    @PostMapping("/create-file")
    public ResponseEntity<File> createFile(@RequestBody CreateFileRequest request) throws Exception {
        //user permission should be handel by spring security but i but it in request for simplicity
        File createdFile = itemService.createFile(request.getParentId(), request.getFileName(), request.getFileContent(), request.getUserWithEditAccessEmail());
        //response should be DTO object but return entity for simplicity
        return new ResponseEntity<>(createdFile, HttpStatus.CREATED);
    }
}
