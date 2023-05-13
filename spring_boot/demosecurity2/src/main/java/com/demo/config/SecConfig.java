package com.demo.config;

import com.demo.api.AccessDeniedExHandler;
import com.demo.api.AuthenticationExHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@EnableWebSecurity //spring spring boot i want to customized spring sec
public class SecConfig extends WebSecurityConfigurerAdapter {

    //authentication : who is the user --> password
    //encode the pass
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();// spring trying to say only use in hello world
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("raj").password("raj123").roles("ADMIN")
                .and()
                .withUser("ekta").password("ekta123").roles("MGR")
                .and()
                .withUser("gunika").password("gun123").roles("EMP");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //for rest basesd app we can disable csrf
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
                .antMatchers("/emp/**").hasAnyRole("ADMIN","MGR","EMP")
                .antMatchers("/home/**").permitAll()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new AuthenticationExHandler())
                .accessDeniedHandler(new AccessDeniedExHandler());
    }

    protected SecConfig() {
        super();
    }
}




















