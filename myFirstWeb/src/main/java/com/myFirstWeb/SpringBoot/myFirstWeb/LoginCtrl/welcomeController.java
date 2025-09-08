package com.myFirstWeb.SpringBoot.myFirstWeb.LoginCtrl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class welcomeController {

//    private AuthenticationService auth;
//
//    public LoginController(AuthenticationService auth) {
//        this.auth = auth;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomepg(ModelMap model){
        model.put("name", getLoggedinUser());
        return "welcome";
    }

    private String getLoggedinUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
















//
//    @RequestMapping(value = "welcome", method = RequestMethod.POST)
//    public String welcomepg(@RequestParam String name,
//                            @RequestParam String password, ModelMap model){
//
//        if(auth.authentication(name, password)){
//            model.put("name", name);
//            model.put("password", password);
//
//            //Authentication
//
//            return "welcome";
//        }
//        model.put("errorMsg","inValid credentials");
//        return "login";
//    }
}
