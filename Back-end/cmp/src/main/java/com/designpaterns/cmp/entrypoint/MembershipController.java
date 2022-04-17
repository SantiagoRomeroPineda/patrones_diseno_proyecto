package com.designpaterns.cmp.entrypoint;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.designpaterns.cmp.core.usecase.impl.ManageMembershipUseCase;
import com.designpaterns.cmp.infrastructure.database.model.membership.Membership;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/membership")
public class MembershipController {

	private final ManageMembershipUseCase manageMembershipUseCase;

	@GetMapping("/get_memberchip_by_id/{membershipId}")
	public Membership getMembershipById(@PathVariable final String membershipId){
		return manageMembershipUseCase.findById(membershipId);
	}

	@GetMapping("/get_all")
	public List<Membership> getAllMemberships(){
		return manageMembershipUseCase.findAll();
	}

}
