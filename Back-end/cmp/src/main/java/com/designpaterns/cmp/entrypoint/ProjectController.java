package com.designpaterns.cmp.entrypoint;

import java.util.List;

import com.designpaterns.cmp.core.usecase.impl.AdapterFileUploader;
import com.designpaterns.cmp.core.usecase.impl.ManageProjectUseCase;
import com.designpaterns.cmp.infrastructure.database.model.file.File;
import com.designpaterns.cmp.infrastructure.database.model.project.Project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/project")
public class ProjectController {

    private final ManageProjectUseCase manageProjectUseCase;

    @GetMapping("/{projectId}")
    public Project getProjectById(@PathVariable final String projectId) {
        return manageProjectUseCase.findProjectById(projectId);
    }

    @GetMapping("")
    public List<Project> getAllProjects() {
        return manageProjectUseCase.findAllProjects();
    }

    @PostMapping("/{userId}")
    public void createProject(@RequestBody Project project, @PathVariable String userId) {
        manageProjectUseCase.create_project(project, userId);
    }

    @PutMapping("/file/{projectId}")
    public void addFile(@RequestBody File file, @PathVariable String projectId) {
        AdapterFileUploader ad = new AdapterFileUploader(manageProjectUseCase);
        ad.uploadFile(file, projectId);
    }

    @PutMapping("/file/remove/{projectId}")
    public void removeFile(@RequestBody File file, @PathVariable String projectId) {
        AdapterFileUploader ad = new AdapterFileUploader(manageProjectUseCase);
        ad.removeFile(file.get_id(), projectId);
    }
}
