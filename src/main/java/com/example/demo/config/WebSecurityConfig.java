package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.sql.DataSource;


    @Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private DataSource dataSource;

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()


                    .anyRequest().permitAll()
                    .and().csrf().disable()
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .loginProcessingUrl("/login-process")
                    .failureUrl("/login?error")
                    .defaultSuccessUrl("/profilkursanta");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication()
                    .usersByUsernameQuery("SELECT email, password, enabled from user WHERE email=?")
                    .authoritiesByUsernameQuery("SELECT email, role FROM user WHERE email = ?")
                    .dataSource(dataSource)
                    .passwordEncoder(bCryptPasswordEncoder);
        }
    }



