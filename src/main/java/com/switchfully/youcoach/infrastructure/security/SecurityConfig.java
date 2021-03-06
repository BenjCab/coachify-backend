package com.switchfully.youcoach.infrastructure.security;

import com.switchfully.youcoach.infrastructure.security.authentication.OnAuthenticationFailureHandler;
import com.switchfully.youcoach.infrastructure.security.authentication.jwt.JwtAuthenticationFilter;
import com.switchfully.youcoach.infrastructure.security.authentication.jwt.JwtAuthorizationFilter;
import com.switchfully.youcoach.infrastructure.security.authentication.jwt.JwtGenerator;
import com.switchfully.youcoach.infrastructure.security.authentication.user.SecuredUserService;
import com.switchfully.youcoach.infrastructure.security.authentication.user.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.List;

@Profile("production")
@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final JwtGenerator jwtGenerator;
    private final SecuredUserService securedUserService;
    private final AccountService accountService;


    public SecurityConfig(SecuredUserService securedUserService,
                          PasswordEncoder passwordEncoder,
                          JwtGenerator jwtGenerator,
                          AccountService accountService) {

        this.securedUserService = securedUserService;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.accountService = accountService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/security/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), authenticationFailureHandler(), jwtGenerator, accountService))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), authenticationFailureHandler(), jwtGenerator))
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable();
    }
*/


    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new OnAuthenticationFailureHandler();
    }

    //todo change this back when we enable security
   @Bean
   CorsFilter corsFilter(@Value("${youcoach.allowed.origins}") List<String> origins) {

       CorsConfiguration corsConfig = new CorsConfiguration();
       corsConfig.setMaxAge(8000L);
       corsConfig.setAllowCredentials(true);
       corsConfig.setAllowedOrigins(origins);
       corsConfig.addAllowedHeader("*");
       corsConfig.addAllowedMethod("GET");
       corsConfig.addAllowedMethod("POST");
       corsConfig.addAllowedMethod("PUT");
       corsConfig.addAllowedMethod("PATCH");
       corsConfig.addAllowedMethod("DELETE");


       UrlBasedCorsConfigurationSource source =
               new UrlBasedCorsConfigurationSource();
       source.registerCorsConfiguration("/**", corsConfig);

       return new CorsFilter(source);
   }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securedUserService).passwordEncoder(passwordEncoder);
    }



}
