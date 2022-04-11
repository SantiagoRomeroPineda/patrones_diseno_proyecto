package com.designpaterns.cmp.infrastructure;

import com.designpaterns.cmp.infrastructure.database.model.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserProvider {

	private final UserRepository userRepository;

}
