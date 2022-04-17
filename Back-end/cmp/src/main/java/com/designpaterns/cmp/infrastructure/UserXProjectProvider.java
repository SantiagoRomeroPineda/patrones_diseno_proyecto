package com.designpaterns.cmp.infrastructure;

import java.util.List;

import com.designpaterns.cmp.infrastructure.database.model.uxp.UserXProject;
import com.designpaterns.cmp.infrastructure.database.model.uxp.UserXProjectRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserXProjectProvider {

	private final UserXProjectRepository userXProjectRepository;

	public void save(final UserXProject userXProject){
		userXProjectRepository.save(userXProject);
	}

	public List<UserXProject> getProjectsByUserId(final String userId){
		return userXProjectRepository.findAllByUser__id(userId);
	}

}
