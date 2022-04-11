package com.designpaterns.cmp.infrastructure;

import com.designpaterns.cmp.infrastructure.database.model.membership.MembershipRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MembershipProvider {

	private final MembershipRepository membershipRepository;
}
