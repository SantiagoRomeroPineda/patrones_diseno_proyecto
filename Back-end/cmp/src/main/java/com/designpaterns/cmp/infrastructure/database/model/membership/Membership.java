package com.designpaterns.cmp.infrastructure.database.model.membership;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document(collection = "membership")
@NoArgsConstructor
public class Membership {
    @Id
    private String _id;
    private String description;
    private int projects_amount_allowed;
    private Double space_size_allowed;
    private String type;
    private Double cost;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProjects_amount_allowed() {
        return projects_amount_allowed;
    }

    public void setProjects_amount_allowed(int projects_amount_allowed) {
        this.projects_amount_allowed = projects_amount_allowed;
    }

    public Double getSpace_size_allowed() {
        return space_size_allowed;
    }

    public void setSpace_size_allowed(Double space_size_allowed) {
        this.space_size_allowed = space_size_allowed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

}
