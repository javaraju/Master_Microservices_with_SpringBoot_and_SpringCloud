package com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response;

public class HelloWorldResponse {
    private String message;

    public HelloWorldResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldResponseBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
