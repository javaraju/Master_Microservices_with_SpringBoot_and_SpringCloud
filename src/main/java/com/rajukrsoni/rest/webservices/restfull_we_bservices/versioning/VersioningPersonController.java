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
}
