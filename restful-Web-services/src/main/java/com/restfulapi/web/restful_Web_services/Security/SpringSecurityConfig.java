package com.restfulapi.web.restful_Web_services.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        //(1) All Request should be authenticated
        httpSecurity.authorizeHttpRequests(
                auth-> auth.anyRequest()
                                                      .authenticated());

        //(2) If a request is not authenticated, a web page is shown
        httpSecurity.httpBasic(Customizer.withDefaults());

        //(3) CSRF -> POST, PUT
        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }
}
