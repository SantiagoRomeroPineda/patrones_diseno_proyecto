package com.designpaterns.cmp.core.usecase.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.designpaterns.cmp.infrastructure.ProjectProvider;
import com.designpaterns.cmp.infrastructure.UserProvider;
import com.designpaterns.cmp.infrastructure.UserXProjectProvider;
import com.designpaterns.cmp.infrastructure.database.model.project.Project;
import com.designpaterns.cmp.infrastructure.database.model.user.User;
import com.designpaterns.cmp.infrastructure.database.model.uxp.UserXProject;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManageProjectUseCase {

    private final ProjectProvider projectProvider;
    private final UserXProjectProvider userXProjectProvider;
    private final UserProvider userProvider;

    public Project findProjectById(final String projectId) {
        final Optional<Project> projectOp = projectProvider.findById(projectId);
        if (projectOp.isPresent()) {
            return projectOp.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "project not found");
    }

    public List<Project> findAllProjects() {
        return projectProvider.findAll();
    }

    public void create_project(Project project, String userId) {
        Date creation_date = new Date();
        project.setCreation_date(creation_date);
        projectProvider.save(project);
        User user = new User();
        final Optional<User> userOp = userProvider.findById(userId);
        if (userOp.isPresent()) {
            user = userOp.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        UserXProject userXProject = new UserXProject();
        userXProject.setProject(project);
        userXProject.setUser(user);
        userXProject.setRole("Admin");
        userXProject.setPriviliges("All");

        userXProjectProvider.save(userXProject);

    }

}
