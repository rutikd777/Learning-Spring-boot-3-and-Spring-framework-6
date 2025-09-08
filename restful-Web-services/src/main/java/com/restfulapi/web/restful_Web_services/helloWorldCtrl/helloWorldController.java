package com.restfulapi.web.restful_Web_services.helloWorldCtrl;
import org.springframework.web.bind.annotation.*;

@RestController
public class helloWorldController {

    @GetMapping("hello-world")
    public String helloWorld(){
        return "hello World";
    }

    @GetMapping("hello-world-bean")
    public helloWorldBean helloWorldBean(){
        return new helloWorldBean( "hello World bean");
    }

    @GetMapping("hello-world-bean/path-variable/{name}")
    public helloWorldBean helloWorldBean(@PathVariable String name){
//        return new helloWorldBean( "hello World bean " + name);
        return new helloWorldBean(String.format("Hello world, %s", name));
    }
}
