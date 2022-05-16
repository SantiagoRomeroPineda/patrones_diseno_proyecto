package com.designpaterns.cmp.core.usecase.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.designpaterns.cmp.infrastructure.MembershipProvider;
import com.designpaterns.cmp.infrastructure.database.model.membership.Membership;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManageMembershipUseCase {

	private  final  MembershipProvider membershipProvider;

	public  Membership findById(final String membershipId){
		final Optional<Membership> membershipOp = membershipProvider.findById(membershipId);
		if(membershipOp.isPresent()){
			return membershipOp.get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "membership not found");
	}

	public List<Membership> findAll() {
		return membershipProvider.findAll();
	}
}
