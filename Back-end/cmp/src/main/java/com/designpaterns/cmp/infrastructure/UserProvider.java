package com.designpaterns.cmp.infrastructure;

import java.util.List;
import java.util.Optional;

import com.designpaterns.cmp.infrastructure.database.model.user.User;
import com.designpaterns.cmp.infrastructure.database.model.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserProvider {

	private final UserRepository userRepository;

	public Optional<User> findById(final String id) {

		return userRepository.findById(id);
	}

	public void save(User user){
		userRepository.save(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
}
