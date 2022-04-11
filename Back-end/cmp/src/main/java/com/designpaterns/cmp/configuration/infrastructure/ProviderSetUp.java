package com.designpaterns.cmp.configuration.infrastructure;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.designpaterns.cmp.infrastructure.FileProvider;
import com.designpaterns.cmp.infrastructure.InvoiceProvider;
import com.designpaterns.cmp.infrastructure.MembershipProvider;
import com.designpaterns.cmp.infrastructure.ProjectProvider;
import com.designpaterns.cmp.infrastructure.UserProvider;
import com.designpaterns.cmp.infrastructure.UserXProjectProvider;
import com.designpaterns.cmp.infrastructure.database.model.file.FileRepository;
import com.designpaterns.cmp.infrastructure.database.model.invoice.InvoiceRepository;
import com.designpaterns.cmp.infrastructure.database.model.membership.Membership;
import com.designpaterns.cmp.infrastructure.database.model.membership.MembershipRepository;
import com.designpaterns.cmp.infrastructure.database.model.project.ProjectRepository;
import com.designpaterns.cmp.infrastructure.database.model.user.UserRepository;
import com.designpaterns.cmp.infrastructure.database.model.uxp.UserXProjectRepository;

@Configuration
@EntityScan("com.designpaterns.cmp.infrastructure.model")
@EnableMongoRepositories("com.designpaterns.cmp.infrastructure")
public class ProviderSetUp {

	@Bean
	public FileProvider fileProvider(final FileRepository fileRepository){
		return new FileProvider(fileRepository);
	}

	@Bean
	public InvoiceProvider invoiceProvider(final InvoiceRepository invoiceRepository){
		return new InvoiceProvider(invoiceRepository);
	}

	@Bean
	public MembershipProvider membershipProvider(final MembershipRepository membershipRepository){
		return new MembershipProvider(membershipRepository);
	}

	@Bean
	public ProjectProvider projectProvider(final ProjectRepository projectRepository){
		return new ProjectProvider(projectRepository);
	}

	@Bean
	public UserProvider userProvider(final UserRepository userRepository){
		return new UserProvider(userRepository);
	}

	@Bean
	public UserXProjectProvider userXProjectProvider(final UserXProjectRepository userXProjectRepository){
		return new UserXProjectProvider(userXProjectRepository);
	}

}
