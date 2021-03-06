package com.designpaterns.cmp.core.usecase.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.designpaterns.cmp.core.usecase.impl.encrypt.encriptacion.ProcesoEncriptarAES;
import com.designpaterns.cmp.core.usecase.impl.encrypt.implementacion.InterfaceMensajeEncriptacion;
import com.designpaterns.cmp.core.usecase.impl.encrypt.implementacion.PuenteMensajeEncriptacion;
import com.designpaterns.cmp.infrastructure.UserProvider;
import com.designpaterns.cmp.infrastructure.database.model.membership.Membership;
import com.designpaterns.cmp.infrastructure.database.model.project.Project;
import com.designpaterns.cmp.infrastructure.database.model.user.User;
import com.designpaterns.cmp.infrastructure.database.model.uxp.UserXProject;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManageUserUseCase {

	private final UserProvider userProvider;
	private final ManageMembershipUseCase membershipUseCase;
	private final ManageUserByProjectUseCase manageUserByProjectUseCase;
	private final ManageProjectUseCase manageProjectUseCase;

	static String SEED ="HG58YZ3CR9123456";

	public void save(final User user) throws Exception {
		InterfaceMensajeEncriptacion FormatoAES = new PuenteMensajeEncriptacion(new ProcesoEncriptarAES());
		user.setPassword(FormatoAES.EncryptarMensaje(user.getPassword(), SEED));
		userProvider.save(user);
	}

	public List<User> findAll() {
		return userProvider.findAll();
	}

	public User findById(final String id) {
		final Optional<User> userOp = userProvider.findById(id);
		if (userOp.isPresent()) {
			return userOp.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
	}

	public void setMemberShipForUser(final String userId, final String membershipId) {
		User user = findById(userId);
		Membership membership = membershipUseCase.findById(membershipId);
		user.setMembership(membership);
		userProvider.save(user);

	}

	public List<Project> getUserProjects(final String userId) {
		List<Project> userProjects = new ArrayList<>();
		List<UserXProject> uxp = manageUserByProjectUseCase.findUserProjects(userId);
		for (UserXProject userXProject : uxp) {
			Project aux = manageProjectUseCase.findProjectById(userXProject.getProject().get_id());
			userProjects.add(aux);
		}
		return userProjects;
	}

	public String login(final String email, final String password) throws Exception {
		String token = "";
		InterfaceMensajeEncriptacion FormatoAES = new PuenteMensajeEncriptacion(new ProcesoEncriptarAES());
		User auxUser = findUserByEmailPass(email, FormatoAES.EncryptarMensaje(password, SEED));
		if (auxUser == null)
			return "";
		RandomString rs = new RandomString();
		token = rs.nextString();
		auxUser.setToken(token);
		userProvider.save(auxUser);
		return token;
	}

	public User findUserByEmailPass(final String email, final String password) {
		List<User> users = userProvider.findAll();
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password))
				return user;
		}
		return null;
	}

	public String signUp(User user) throws Exception {
		String token = "";
		Optional<User> user_op = userProvider.findByEmail(user.getEmail());
		InterfaceMensajeEncriptacion FormatoAES = new PuenteMensajeEncriptacion(new ProcesoEncriptarAES());

		if (user_op.isPresent()) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"User already exist");
		}

		user.setPassword(FormatoAES.EncryptarMensaje(user.getPassword(), SEED));
		RandomString rs = new RandomString();
		token = rs.nextString();

		user.setToken(token);

		userProvider.save(user);

		return token;
	}
}
