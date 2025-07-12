package com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response;

public class NameResponse {
    private String firstName;
    private String lastName;

    public NameResponse(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "NameResponse{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
