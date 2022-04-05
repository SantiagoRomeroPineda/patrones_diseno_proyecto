package com.designpaterns.cmp.infrastructure.database.model;

import java.util.List;

import com.designpaterns.cmp.infrastructure.database.model.file.File;
import com.designpaterns.cmp.infrastructure.database.model.file.FileRepository;
import com.designpaterns.cmp.infrastructure.database.model.invoice.Invoice;
import com.designpaterns.cmp.infrastructure.database.model.invoice.InvoiceRepository;
import com.designpaterns.cmp.infrastructure.database.model.membership.Membership;
import com.designpaterns.cmp.infrastructure.database.model.membership.MembershipRepository;
import com.designpaterns.cmp.infrastructure.database.model.project.Project;
import com.designpaterns.cmp.infrastructure.database.model.project.ProjectRepository;
import com.designpaterns.cmp.infrastructure.database.model.user.User;
import com.designpaterns.cmp.infrastructure.database.model.user.UserRepository;
import com.designpaterns.cmp.infrastructure.database.model.uxp.UserXProject;
import com.designpaterns.cmp.infrastructure.database.model.uxp.UserXProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class ControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserXProjectRepository userXProjectRepository;

    /**
     * {
     * "name":"Nelson",
     * "email":"test@gmail.com",
     * "password":"xxxxxx"
     * }
     */
    @PostMapping("/user")
    public boolean create_user(@RequestBody User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @PutMapping("/user")
    public boolean update_user() {
        Invoice i = invoiceRepository.findById("624bc1e0d4a6b66715de68b1").get();
        Membership m = membershipRepository.findById("624bc311d4a6b66715de68b7").get();
        User u = userRepository.findById("624bc664d4a6b66715de68c3").get();
        u.addInvoice(i);
        u.setMembership(m);
        userRepository.save(u);
        return true;
    }

    @GetMapping("/user")
    public List<User> get_users() {
        return userRepository.findAll();
    }

    /**
     * {
     * "url_path":"url_path",
     * "type":"mp4",
     * "size":20
     * }
     */
    @PostMapping("/file")
    public boolean create_file(@RequestBody File file) {
        try {
            fileRepository.save(file);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @GetMapping("/file")
    public List<File> get_files() {
        return fileRepository.findAll();
    }

    /**
     * {
     * "invoice_date":"2022-01-01",
     * "total_space_size": 20,
     * "space_size": 20,
     * "total_cost": 20,
     * "paid":20,
     * "over_price":20
     * }
     */
    @PostMapping("/invoice")
    public boolean create_invoice(@RequestBody Invoice invoice) {
        try {
            invoiceRepository.save(invoice);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @GetMapping("/invoice")
    public List<Invoice> get_invoices() {
        return invoiceRepository.findAll();
    }

    /**
     * {
     * "description":"asd",
     * "projects_amount_allowed": 20,
     * "space_size_allowed": 20,
     * "type": "20",
     * "cost":20
     * }
     */
    @PostMapping("/ms")
    public boolean create_ms(@RequestBody Membership ms) {
        try {
            membershipRepository.save(ms);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @GetMapping("/ms")
    public List<Membership> get_ms() {
        return membershipRepository.findAll();
    }

    /**
     * {
     * "name":"asd",
     * "description": 20,
     * "creation_date": "2022-02-02",
     * "total_size": "20"
     * }
     */
    @PostMapping("/project")
    public boolean create_project(@RequestBody Project p) {
        try {
            projectRepository.save(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @GetMapping("/project")
    public List<Project> get_projects() {
        return projectRepository.findAll();
    }

    @PutMapping("/project")
    public boolean update_projects() {
        File f = fileRepository.findById("624bc04f2368231748f5bf22").get();
        Project p = projectRepository.findById("624bc411d4a6b66715de68b9").get();
        p.addFile(f);
        projectRepository.save(p);
        return true;
    }

    @PostMapping("/uxp")
    public boolean create_project() {
        Project p = projectRepository.findById("624bc411d4a6b66715de68b9").get();
        User u = userRepository.findById("624bc664d4a6b66715de68c3").get();
        UserXProject uxp = new UserXProject();
        uxp.setPriviliges("priviliges");
        uxp.setRole("role");
        uxp.setUser(u);
        uxp.setProject(p);
        userXProjectRepository.save(uxp);
        return true;
    }

    @GetMapping("/uxp")
    public List<UserXProject> get_uxp() {
        return userXProjectRepository.findAll();
    }
}
