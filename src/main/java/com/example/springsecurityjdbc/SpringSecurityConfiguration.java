package com.example.springsecurityjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity      // TO enable Spring give us the auth object
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    final
    DataSource dataSource;      // If you add an embeedded database to springboot app, springboot is smart enough to activate it as your database

    @Autowired
    public SpringSecurityConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource);
                 //Telling spring to create a default tables;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")     // antMatchers used to specify the path
                .antMatchers("/user").hasAnyRole("USER", "ADMIN")      // Can pass in list of roles that have access.
                .antMatchers("/").permitAll()       //Tells spring to permit this API to all users
                .and().formLogin();         // default configuration of spring, specifies the type of login for spring to use

//              .antMatchers("/**")     //specifies API's using wildcards. States that all APIs can be accessed
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {       // Final method for authentication. setting up as password encoder. Do not use the nooppassworencoder
        return NoOpPasswordEncoder.getInstance();
    }
}
