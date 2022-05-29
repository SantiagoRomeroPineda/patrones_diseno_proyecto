package com.designpaterns.cmp.core.usecase.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.designpaterns.cmp.infrastructure.FileProvider;
import com.designpaterns.cmp.infrastructure.ProjectProvider;
import com.designpaterns.cmp.infrastructure.UserProvider;
import com.designpaterns.cmp.infrastructure.UserXProjectProvider;
import com.designpaterns.cmp.infrastructure.database.model.file.File;
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
    private final FileProvider fileProvider;

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

    public void addFile(File file, String projectId) {
        if (!projectProvider.findById(projectId).isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Project doesnt exist");
        Project project = projectProvider.findById(projectId).get();
        if (project.getTotal_size() + file.getSize() > 50)
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "There is no more space in this project");
        fileProvider.save(file);
        project.addFile(file);
        projectProvider.save(project);
    }

    public void deleteFile(String fileId, String projectId) {
        if (!projectProvider.findById(projectId).isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Project doesnt exist");
        if (!fileProvider.findById(fileId).isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "File doesnt exist");
        Project project = projectProvider.findById(projectId).get();
        File file = fileProvider.findById(fileId).get();

        if (project.getFile().removeIf(f -> f.get_id().equals(fileId))) {
            fileProvider.deleteById(fileId);
            projectProvider.save(project);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "File doesnt exist in this project");
    }

}
