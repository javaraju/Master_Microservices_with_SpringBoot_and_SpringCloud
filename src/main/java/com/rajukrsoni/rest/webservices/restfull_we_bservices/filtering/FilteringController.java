package com.rajukrsoni.rest.webservices.restfull_we_bservices.filtering;

import com.rajukrsoni.rest.webservices.restfull_we_bservices.Dto.response.FilteringResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path = "/filtering")
    public FilteringResponse filtering(){
        return new FilteringResponse("user1", "user2", "user3");
    }

    @GetMapping(path = "/filtering-list")
    public List<FilteringResponse> filteringList(){
        return Arrays.asList(new FilteringResponse("user1", "user2", "user3"),
                new FilteringResponse("user1", "user2", "user3"));
    }
}
