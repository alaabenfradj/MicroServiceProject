package com.esprit.microservices.security.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import javax.servlet.Filter;
import javax.ws.rs.HttpMethod;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/api/login/**", "/api/refresh/**").permitAll();
        http.authorizeRequests().antMatchers("/events/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/forums/user/**").hasAnyAuthority("ROLE_ADMIN");
/*        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/role/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/**").hasAnyAuthority("ROLE_USER");*/
        http.authorizeRequests().anyRequest().authenticated();

        http.addFilterBefore((Filter) new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
