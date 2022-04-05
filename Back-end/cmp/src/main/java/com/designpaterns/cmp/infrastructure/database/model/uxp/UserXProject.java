package com.designpaterns.cmp.infrastructure.database.model.uxp;

import com.designpaterns.cmp.infrastructure.database.model.project.Project;
import com.designpaterns.cmp.infrastructure.database.model.user.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document(collection = "UserxProject")
@NoArgsConstructor
public class UserXProject {

    @Id
    private String _id;
    @DBRef
    User user;
    @DBRef
    Project project;
    private String role;
    private String priviliges;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPriviliges() {
        return priviliges;
    }

    public void setPriviliges(String priviliges) {
        this.priviliges = priviliges;
    }

}
