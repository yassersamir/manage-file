package com.yasser.managefile.dto.request;

public class CreateFileRequest {
    private Long parentId;
    private String fileName;
    private byte[] fileContent;
    private String userWithEditAccessEmail;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public String getUserWithEditAccessEmail() {
        return userWithEditAccessEmail;
    }

    public void setUserWithEditAccessEmail(String userWithEditAccessEmail) {
        this.userWithEditAccessEmail = userWithEditAccessEmail;
    }
}
