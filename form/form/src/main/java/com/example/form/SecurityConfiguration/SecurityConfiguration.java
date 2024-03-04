package com.example.form.SecurityConfiguration;

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

@Configuration
public class SecurityConfiguration {

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetails=new JdbcUserDetailsManager(dataSource);

        return jdbcUserDetails;

    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                               .requestMatchers(HttpMethod.GET, "/app/employees","/app/employee/*","/app/employee").hasAnyRole( "ADMIN", "MANAGER")
                               .requestMatchers(HttpMethod.POST, "/app/employees","/app/employee/*","/app/employee").hasAnyRole( "ADMIN", "MANAGER")
                               .requestMatchers(HttpMethod.DELETE, "/app/employees","/app/employee/*","/app/employee").hasAnyRole( "ADMIN", "MANAGER")
                               .requestMatchers(HttpMethod.PUT, "/app/employees","/app/employee/*","/app/employee").hasAnyRole( "ADMIN", "MANAGER")
                               .requestMatchers(HttpMethod.GET, "/app/leaves","/app/leave/*","/app/leave").hasAnyRole( "EMPLOYEE","ADMIN", "MANAGER")
                               .requestMatchers(HttpMethod.POST, "/app/leaves","/app/leave/*","/app/leave").hasAnyRole( "EMPLOYEE","ADMIN", "MANAGER")
                                .anyRequest().authenticated()


                )
                .formLogin(form ->
                        form
                                .loginPage("/app/showmyloginpage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .defaultSuccessUrl("/app/leaves")
                                .permitAll()


                )
                .exceptionHandling(
                        configurer->configurer
                                .accessDeniedPage("/app/accessdenied")
                )

        ;

        return http.build();
    }

}
