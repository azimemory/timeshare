package com.gom.timeshare.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }

    @Override  //WebSecurity는 FilterChainProxy를 생성하는 필터입니다.
    public void configure(WebSecurity web) throws Exception {
        //정적 자원에 대해서는 security 설정을 적용하지 않음
        web.ignoring()
                .mvcMatchers("/static/**")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/", "/member/login", "/member/join", "/member/id-check").permitAll()
                .mvcMatchers(HttpMethod.POST, "/member/mail-auth", "/mail", "/member/login-impl","/member/id-check").permitAll()
                .antMatchers("/member/join-impl/**","/login/oauth2/code/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();

        http.formLogin()
                .loginProcessingUrl("/member/login-impl")
                .usernameParameter("userId")
                .loginPage("/member/login").permitAll()
                .defaultSuccessUrl("/", true);

        http.logout()
                .logoutUrl("/member/logout")
                .logoutSuccessUrl("/index");

        http.csrf()
                .ignoringAntMatchers("/mail/**");
    }
}
