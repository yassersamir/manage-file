package com.yasser.managefile.dto.request;

public class CreateFolderRequest {

    private Long parentId;
    private String folderName;
    private String userWithEditAccessEmail;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getUserWithEditAccessEmail() {
        return userWithEditAccessEmail;
    }

    public void setUserWithEditAccessEmail(String userWithEditAccessEmail) {
        this.userWithEditAccessEmail = userWithEditAccessEmail;
    }
}
