package com.rajukrsoni.rest.webservices.restfull_we_bservices.versioning;

import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response.NameResponse;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response.PersonV1Response;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response.PersonV2Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping(path = "/v1/person")
    public PersonV1Response getFirstVersionOfPerson(){
        return new PersonV1Response("Raju kumar");
    }
    @GetMapping(path = "/v2/person")
    public PersonV2Response getSecondVersionOfPerson(){
        return new PersonV2Response(new NameResponse("Raju", "kumar"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1Response getFirstVersionOfPersonRequestParameter(){
        return new PersonV1Response("Raju kumar");
    }
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2Response getSecondVersionOfPersonRequestParameter(){
        return new PersonV2Response(new NameResponse("Raju", "kumar"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1Response getFirstVersionOfPersonRequestHeader(){
        return new PersonV1Response("Raju kumar");
    }
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2Response getSecondVersionOfPersonRequestHeader(){
        return new PersonV2Response(new NameResponse("Raju", "kumar"));
    }
}
