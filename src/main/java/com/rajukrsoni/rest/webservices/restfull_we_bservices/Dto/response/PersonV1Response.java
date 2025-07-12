package com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response;

public class PersonV1Response {
    private String name;

    public PersonV1Response(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonV1ResponseBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
