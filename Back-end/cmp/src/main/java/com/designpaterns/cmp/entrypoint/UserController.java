package com.designpaterns.cmp.entrypoint;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.designpaterns.cmp.core.usecase.impl.ManageUserUseCase;
import com.designpaterns.cmp.infrastructure.database.model.project.Project;
import com.designpaterns.cmp.infrastructure.database.model.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

	private final ManageUserUseCase manageUserUseCase;

	@PostMapping("/create_user")
	public boolean createUser(@RequestBody User user) {
		manageUserUseCase.save(user);
		return true;

	}

	@PutMapping("/update_user_membership/{userId}/{membershipId}")
	public boolean updateUserMembership(@PathVariable final String userId, @PathVariable final String membershipId) {
		manageUserUseCase.setMemberShipForUser(userId, membershipId);
		return true;
	}

	@GetMapping("/get_users")
	public List<User> getUsers() {
		return manageUserUseCase.findAll();
	}

	@GetMapping("/{userId}")
	public List<Project> getProjects(@PathVariable final String userId) {
		return manageUserUseCase.getUserProjects(userId);
	}

}
