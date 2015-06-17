package com.brick.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.brick.security.CookieAuthenticationFilter;
import com.brick.security.CustomLogoutSuccessHandler;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfig extends WebSecurityConfigurerAdapter {

	//DAO模式
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	CookieAuthenticationFilter filterAuth = new CookieAuthenticationFilter();
    	filterAuth.setAuthenticationManager(authenticationManager());
    	filterAuth.setCheckForPrincipalChanges(true);
    	filterAuth.setInvalidateSessionOnPrincipalChange(true);
        http
        	//.addFilter(filterAuth)
        	.authorizeRequests()
            .antMatchers("/public/**").permitAll()
            .antMatchers("/users/**").hasAuthority("ADMIN")
            .anyRequest().fullyAuthenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .usernameParameter("email")
            .permitAll()
            .and()
            .logout()
            .logoutSuccessHandler(new CustomLogoutSuccessHandler())
            //.logoutUrl("/logout")
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .deleteCookies("remember-me")
            //.logoutSuccessUrl("/")
            .permitAll();
            //.and()
            //.rememberMe();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    	  web.ignoring().antMatchers("/assets/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        	.passwordEncoder(new BCryptPasswordEncoder());
    }

}