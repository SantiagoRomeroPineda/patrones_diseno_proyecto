package com.designpaterns.cmp.core.usecase.impl;

import java.util.List;

import com.designpaterns.cmp.infrastructure.UserXProjectProvider;
import com.designpaterns.cmp.infrastructure.database.model.uxp.UserXProject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManageUserByProjectUseCase {

    private final UserXProjectProvider userXProjectProvider;

    public List<UserXProject> findUserProjects(final String userId) {
        return userXProjectProvider.getProjectsByUserId(userId);
    }

    public void save(UserXProject uxp) {
        userXProjectProvider.save(uxp);
    }
}
