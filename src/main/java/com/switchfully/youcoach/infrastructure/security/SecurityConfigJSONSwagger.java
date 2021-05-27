package com.switchfully.youcoach.infrastructure.security;

import com.switchfully.youcoach.infrastructure.security.authentication.jwt.JwtGenerator;
import com.switchfully.youcoach.service.RequestRejectedExceptionFilter;
import com.switchfully.youcoach.service.SecuredUserService;
import com.switchfully.youcoach.service.AccountService;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Profile("development")
@EnableWebSecurity(debug=false)
public class SecurityConfigJSONSwagger extends SecurityConfig {
    private final SecuredUserService securedUserService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfigJSONSwagger(SecuredUserService securedUserService,
                                     PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator, AccountService accountService) {
        super(securedUserService, passwordEncoder, jwtGenerator, accountService);

        this.securedUserService = securedUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/v3/api-docs/**",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/webjars/**");
        super.configure(web);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securedUserService).passwordEncoder(passwordEncoder);
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v3/api-docs/**",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/webjars/**").permitAll();
        http.addFilterBefore(new RequestRejectedExceptionFilter(),
                ChannelProcessingFilter.class);

        super.configure(http);

    }


}
