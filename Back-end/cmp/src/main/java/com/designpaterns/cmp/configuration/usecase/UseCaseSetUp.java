package com.designpaterns.cmp.configuration.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.designpaterns.cmp.core.usecase.impl.ManageInvoiceUseCase;
import com.designpaterns.cmp.core.usecase.impl.ManageUserUseCase;
import com.designpaterns.cmp.core.usecase.impl.ManageMembershipUseCase;
import com.designpaterns.cmp.infrastructure.InvoiceProvider;
import com.designpaterns.cmp.infrastructure.MembershipProvider;
import com.designpaterns.cmp.infrastructure.UserProvider;

@Configuration
@ComponentScan("com.designpaterns.cmp.core.usecase.impl")
public class UseCaseSetUp {

	@Bean
	public ManageUserUseCase manageUserUseCase(final UserProvider userProvider, final ManageMembershipUseCase manageMembershipUseCase){
		return new ManageUserUseCase(userProvider, manageMembershipUseCase);
	}

	@Bean
	public ManageInvoiceUseCase manageInvoiceUseCase(final InvoiceProvider invoiceProvider){
		return new ManageInvoiceUseCase(invoiceProvider);
	}

	@Bean
	public ManageMembershipUseCase manageMembershipUseCase(final MembershipProvider membershipProvider){
		return new ManageMembershipUseCase(membershipProvider);
	}
}
