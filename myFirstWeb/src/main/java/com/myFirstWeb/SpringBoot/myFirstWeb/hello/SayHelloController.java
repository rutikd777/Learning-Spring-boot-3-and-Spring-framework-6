package com.myFirstWeb.SpringBoot.myFirstWeb.hello;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("hello")
    @ResponseBody
    public String SayHello(){
        return "Hello, how is your day going";
    }

    @RequestMapping("hellohtml")
    @ResponseBody
    public String SayHelloHtml(){

        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>");
        sb.append("My first html page");
        sb.append("</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1> My first html page with hello </h1>");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    @RequestMapping("hello-jsp")
    public String SayHellojsp(){
        return "sayHello";
    }
}
