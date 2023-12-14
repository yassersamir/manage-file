package com.yasser.managefile.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "PERMISSION_GROUP")
public class PermissionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "permissionGroup", cascade = CascadeType.ALL)
    private Set<Item> itemList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "permissionGroup", cascade = CascadeType.ALL)
    private Set<Permission> permissionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Set<Item> itemList) {
        this.itemList = itemList;
    }

    public Set<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(Set<Permission> permissionList) {
        this.permissionList = permissionList;
    }
}
