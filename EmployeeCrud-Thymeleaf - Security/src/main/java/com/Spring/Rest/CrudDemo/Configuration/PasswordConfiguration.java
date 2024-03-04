package com.Spring.Rest.CrudDemo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

@Configuration
public class PasswordConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john= User.builder()
                .username("john")
                .password("{noop}fun123")
                .roles("EMPLOYEE").build();
        UserDetails mary= User.builder()
                .username("mary")
                .password("fun123")
                .roles("EMPLOYEE","MANAGER").build();
        UserDetails ria= User.builder()
                .username("ria")
                .password("fun123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,ria);

    }
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer->configurer.anyRequest().hasRole("ADMIN")
        );

        return http.build();

    }

}
