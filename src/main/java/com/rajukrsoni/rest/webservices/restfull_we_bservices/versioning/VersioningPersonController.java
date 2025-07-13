package com.rajukrsoni.rest.webservices.restfull_we_bservices.versioning;

import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response.NameResponse;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response.PersonV1Response;
import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response.PersonV2Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    //URI versioning - Twitter
    @GetMapping(path = "/v1/person")
    public PersonV1Response getFirstVersionOfPerson(){
        return new PersonV1Response("Raju kumar");
    }
    //URI versioning - Twitter
    @GetMapping(path = "/v2/person")
    public PersonV2Response getSecondVersionOfPerson(){
        return new PersonV2Response(new NameResponse("Raju", "kumar"));
    }

    //RequestParameter Versioning - Amazon
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1Response getFirstVersionOfPersonRequestParameter(){
        return new PersonV1Response("Raju kumar");
    }
    //RequestParameter Versioning - Amazon
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2Response getSecondVersionOfPersonRequestParameter(){
        return new PersonV2Response(new NameResponse("Raju", "kumar"));
    }
    //Headers Versioning - Microsoft (SAME URL)
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1Response getFirstVersionOfPersonRequestHeader(){
        return new PersonV1Response("Raju kumar");
    }
    //Headers Versioning - Microsoft (SAME URL)
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2Response getSecondVersionOfPersonRequestHeader(){
        return new PersonV2Response(new NameResponse("Raju", "kumar"));
    }

    //Media Type Versioning ( a.k.a "Content negotiation" or "accept headers")- GitHub (SAME URL)
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1Response getFirstVersionOfPersonAcceptHeader(){
        return new PersonV1Response("Raju kumar");
    }
    //Media Type Versioning ( a.k.a "Content negotiation" or "accept headers")- GitHub (SAME URL)
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2Response getSecondVersionOfPersonAcceptHeader(){
        return new PersonV2Response(new NameResponse("Raju", "kumar"));
    }
}
