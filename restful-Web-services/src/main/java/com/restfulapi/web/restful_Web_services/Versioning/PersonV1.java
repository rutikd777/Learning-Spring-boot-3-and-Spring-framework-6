package com.restfulapi.web.restful_Web_services.Versioning;

public class PersonV1 {

    private String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
