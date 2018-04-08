package com.example.shoppingwebapplication.config;

import com.example.shoppingwebapplication.Services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuration of permitted pages without signing in
 * Allowed H2 console
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Configuration
    @EnableWebSecurity
    public static class WebApplicationWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserDetailsServiceImpl userDetailsService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http
                    .authorizeRequests().antMatchers("/css/**", "/product/list", "/registration", "/user/save", "/h2/**", "/h2-console/**").permitAll()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/product/list")
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll()
                    .and().headers().frameOptions().disable(); // added to permit h2 console

            http.csrf().disable(); // added to permit h2 console

        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }
    }
}

