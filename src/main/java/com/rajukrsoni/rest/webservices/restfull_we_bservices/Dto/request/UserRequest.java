package com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity(name = "user_details")
public class UserRequest {

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2, message = "Name should have atleast 2 characters")
    @JsonProperty("user_name")
    @Column(name = "user_name")
    private String name;
    @Past(message = "Birth Date should be in the past")
    @Column(name = "birth_date")
    private LocalDate birthdate;

    public UserRequest(Integer id, String name, LocalDate birthdate) {
        super();
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
