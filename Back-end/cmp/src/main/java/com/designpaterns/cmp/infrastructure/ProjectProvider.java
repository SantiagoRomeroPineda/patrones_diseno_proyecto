package com.designpaterns.cmp.infrastructure;

import java.util.List;
import java.util.Optional;

import com.designpaterns.cmp.infrastructure.database.model.project.Project;
import com.designpaterns.cmp.infrastructure.database.model.project.ProjectRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProjectProvider {

	private final ProjectRepository projectRepository;

	public void save(final Project project) {
		projectRepository.save(project);
	}

	public Optional<Project> findById(final String projectId) {
		return projectRepository.findById(projectId);
	}

	public List<Project> findAll() {
		return projectRepository.findAll();
	}

}
