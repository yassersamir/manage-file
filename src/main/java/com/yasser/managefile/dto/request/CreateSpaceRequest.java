package com.yasser.managefile.dto.request;

public class CreateSpaceRequest {
    private String spaceName;
    private String permissionGroupName;
    private String viewUserEmail;
    private String editUserEmail;

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getPermissionGroupName() {
        return permissionGroupName;
    }

    public void setPermissionGroupName(String permissionGroupName) {
        this.permissionGroupName = permissionGroupName;
    }

    public String getViewUserEmail() {
        return viewUserEmail;
    }

    public void setViewUserEmail(String viewUserEmail) {
        this.viewUserEmail = viewUserEmail;
    }

    public String getEditUserEmail() {
        return editUserEmail;
    }

    public void setEditUserEmail(String editUserEmail) {
        this.editUserEmail = editUserEmail;
    }
}
