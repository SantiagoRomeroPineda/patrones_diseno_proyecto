package com.designpaterns.cmp.infrastructure;

import java.util.Optional;

import com.designpaterns.cmp.infrastructure.database.model.membership.Membership;
import com.designpaterns.cmp.infrastructure.database.model.membership.MembershipRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MembershipProvider {

	private final MembershipRepository membershipRepository;

	public Optional<Membership> findById(final String id){
		return membershipRepository.findById(id);
	}
}
