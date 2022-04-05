package com.designpaterns.cmp.infrastructure.database.model.invoice;

import java.util.Date;

import com.designpaterns.cmp.infrastructure.database.model.user.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document(collection = "invoice")
@NoArgsConstructor
public class Invoice {
    @Id
    private String _id;
    private Date invoice_date;
    private Double total_space_size;
    private Double space_size;
    private Double total_cost;
    private Double paid;
    private Double over_price;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Date getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    public Double getTotal_space_size() {
        return total_space_size;
    }

    public void setTotal_space_size(Double total_space_size) {
        this.total_space_size = total_space_size;
    }

    public Double getSpace_size() {
        return space_size;
    }

    public void setSpace_size(Double space_size) {
        this.space_size = space_size;
    }

    public Double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(Double total_cost) {
        this.total_cost = total_cost;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public Double getOver_price() {
        return over_price;
    }

    public void setOver_price(Double over_price) {
        this.over_price = over_price;
    }

}
