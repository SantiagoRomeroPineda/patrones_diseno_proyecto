package com.designpaterns.cmp.infrastructure;

import com.designpaterns.cmp.infrastructure.database.model.uxp.UserXProjectRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserXProjectProvider {

	private final UserXProjectRepository userXProjectRepository;

}
