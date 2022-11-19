package com.microservice.forum.security;




import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import javax.ws.rs.HttpMethod;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/api/login/**", "/api/refresh/**","/forums/**").permitAll();
       // http.authorizeRequests().antMatchers(HttpMethod.GET, "/forums/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER","ROLE_STUDENT","ROLE_TEACHER");
       // http.authorizeRequests().antMatchers( "/forums/**").hasAnyAuthority("ROLE_ADMIN");
/*        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/role/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/**").hasAnyAuthority("ROLE_USER");*/
        http.authorizeRequests().anyRequest().authenticated();

        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


}
