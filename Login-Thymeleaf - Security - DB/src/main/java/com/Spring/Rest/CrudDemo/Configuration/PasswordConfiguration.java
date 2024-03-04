package com.Spring.Rest.CrudDemo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.net.http.HttpRequest;

@Configuration
public class PasswordConfiguration {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource){
        //JdbcUserDetailsManager jdbc=new JdbcUserDetailsManager(datasource);
        //jdbc.setUsersByUsernameQuery("select id,name,password ");


        return new JdbcUserDetailsManager(datasource);

    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                               // .anyRequest().authenticated()

                                .requestMatchers(HttpMethod.GET,"/employees").hasAnyRole("EMPLOYEE","ADMIN","MANAGER")
                                .requestMatchers(HttpMethod.GET,"/manager").hasAnyRole("ADMIN","MANAGER")
                                .requestMatchers(HttpMethod.GET,"/admin").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(
                        logout-> logout.permitAll()
                )
                .exceptionHandling(
                        configurer->configurer
                                .accessDeniedPage("/accessdenied")
                )
        ;
        //http.httpBasic(Customizer.withDefaults());
        //http.csrf(csrf->csrf.disable());

        return http.build();

    }

}
