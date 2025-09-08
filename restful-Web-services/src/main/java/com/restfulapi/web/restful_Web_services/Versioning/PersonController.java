package com.restfulapi.web.restful_Web_services.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    //URI versioning
    @GetMapping("v1/person")
    public PersonV1 firstVersion(){
        return new PersonV1("Suhas kale");
    }

    @GetMapping("v2/person")
    public PersonV2 secondVersion(){
        return new PersonV2(new Name("Suhas","kale"));
    }

    //Parameter Versioning
    @GetMapping( path = "/person", params = "version=1")
    public PersonV1 firstParamsVersion(){
        return new PersonV1("Suhas kale");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 secondParamsVersion(){
        return new PersonV2(new Name("Suhas","kale"));
    }

    //Headers Versioning
    @GetMapping( path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 firstHeadersVersion(){
        return new PersonV1("Suhas kale");
    }


    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 secondHeadersVersion(){
        return new PersonV2(new Name("Suhas","kale"));
    }


    //Content Negotiation -- Accept Header
    @GetMapping( path = "/person/header", produces = "application/vnd.company.app-v1+json")
    public PersonV1 firstAcceptHeadersVersion(){
        return new PersonV1("Suhas kale");
    }

    @GetMapping(path = "/person/header", produces = "application/vnd.company.app-v2+json")
    public PersonV2 secondAcceptHeadersVersion(){
        return new PersonV2(new Name("Suhas","kale"));
    }

}
