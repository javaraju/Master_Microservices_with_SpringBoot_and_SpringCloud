package com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response;

public class PersonV2Response {
    private NameResponse nameResponse;

    public PersonV2Response(NameResponse nameResponse) {
        super();
        this.nameResponse = nameResponse;
    }

    public NameResponse getNameResponse() {
        return nameResponse;
    }

    @Override
    public String toString() {
        return "PersonV2Response{" +
                "nameResponse=" + nameResponse +
                '}';
    }
}
