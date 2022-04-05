package com.designpaterns.cmp.infrastructure.database.model.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.designpaterns.cmp.infrastructure.database.model.file.File;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

@Document(collection = "project")
@NoArgsConstructor
public class Project {
    @Id
    private String _id;
    private String name;
    private String description;
    private Date creation_date;
    private Double total_size;
    @DBRef
    private List<File> file = new ArrayList<>();

    public List<File> getFile() {
        return file;
    }

    public void addFile(File file) {
        this.file.add(file);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Double getTotal_size() {
        return total_size;
    }

    public void setTotal_size(Double total_size) {
        this.total_size = total_size;
    }

}
