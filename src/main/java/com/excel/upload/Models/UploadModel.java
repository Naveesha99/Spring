package com.excel.upload.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UploadModel {
    @Id
    private String id;
    private String Name;
    private String Country;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return "UploadModel{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }

}
