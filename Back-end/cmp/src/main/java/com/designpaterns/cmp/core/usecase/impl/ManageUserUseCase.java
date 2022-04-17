package com.designpaterns.cmp.core.usecase.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.designpaterns.cmp.infrastructure.UserProvider;
import com.designpaterns.cmp.infrastructure.database.model.membership.Membership;
import com.designpaterns.cmp.infrastructure.database.model.user.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManageUserUseCase {

	private final UserProvider userProvider;
	private final ManageMembershipUseCase membershipUseCase;

	public void save(final User user) {
		userProvider.save(user);
	}

	public List<User> findAll() {
		return userProvider.findAll();
	}

	public User findById(final String id) {
		final Optional<User> userOp = userProvider.findById(id);
		if(userOp.isPresent()){
			return userOp.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
	}

	public void setMemberShipForUser(final String userId, final String membershipId){
		User user = findById(userId);
		Membership membership =membershipUseCase.findById(membershipId);
		user.setMembership(membership);
		userProvider.save(user);


	}
}
