package com.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Resource
    private UserDetailsService userDetailsService;	
	
    public SecurityConfig(ModifiedUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

    @SuppressWarnings("removal")
    @Bean
    SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
    	
    	http.csrf().disable()
    	    .authorizeHttpRequests().requestMatchers("/auth/**").permitAll()
    	    .anyRequest().authenticated()
    	    .and().httpBasic();
			
    	return http.build();
    }
    
    @Bean
    AuthenticationManager authManager(AuthenticationConfiguration authConfiguration) throws Exception{
    	return authConfiguration.getAuthenticationManager();
    }
    
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider());
//    }
    
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
	UserDetailsService userRoles() {
		UserDetails student = User.builder().username("student").password("password").roles("STUDENT").build();
		UserDetails planner = User.builder().username("planner").password("password").roles("PLANNER").build();
		UserDetails reviewer = User.builder().username("reviewer").password("password").roles("REVIEWER").build();
		
		return new InMemoryUserDetailsManager(student, planner, reviewer);
	}

}
