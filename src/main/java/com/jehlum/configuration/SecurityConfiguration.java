package com.jehlum.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jehlum.security.AuthenticationSuccess;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
		@Autowired
	    private UserDetailsService userDetailsService;

		@Autowired
		private  AuthenticationSuccess authenticationSuccess;
		
		@Bean
		public PasswordEncoder passwordEncoder(){
	        PasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder;
	    }
		
		
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	                    .antMatchers("/resources/**", "/").permitAll()
	                    .anyRequest().authenticated();
	            
	        http.authorizeRequests().antMatchers("/Admin/**").hasRole("ADMIN").anyRequest().authenticated();
	        
	        http.formLogin()
	                  .loginPage("/")
	                  .permitAll().loginProcessingUrl("/j_security_check")
	                    			.usernameParameter("username")
	                    			.passwordParameter("password")
	                    			.successHandler(authenticationSuccess)
	                    			.failureUrl("/?error=true");
	        http.logout().logoutUrl("/logout")
	                      .logoutSuccessUrl("/")
	                    .permitAll();
	        http.csrf().disable();
	    }

	    
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
}
