package com.designpaterns.cmp.infrastructure;

import com.designpaterns.cmp.infrastructure.database.model.project.ProjectRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProjectProvider {

	private final ProjectRepository projectRepository;

}
