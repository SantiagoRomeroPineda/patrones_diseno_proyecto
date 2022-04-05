package com.designpaterns.cmp.infrastructure.database.model.user;

import java.util.ArrayList;
import java.util.List;

import com.designpaterns.cmp.infrastructure.database.model.invoice.Invoice;
import com.designpaterns.cmp.infrastructure.database.model.membership.Membership;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document(collection = "user")
@NoArgsConstructor
public class User {
    @Id
    private String _id;
    private String name;
    private String email;
    private String password;
    @DBRef
    List<Invoice> invoices = new ArrayList<>();
    @DBRef
    Membership membership;

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
