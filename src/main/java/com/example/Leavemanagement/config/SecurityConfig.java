package com.example.Leavemanagement.config;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.ReactiveSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.session.web.http.SessionRepositoryFilter;

import com.example.Leavemanagement.service.Employeeservice;

@Configuration
@EnableWebSecurity
public class SecurityConfig <S extends Session>{

//	@Bean
//	public MapSessionRepository sessionRepository() {
//		return new MapSessionRepository(new ConcurrentHashMap<>());
//	}
	
	@Autowired
	protected FindByIndexNameSessionRepository<S>sessionRepo;
	
//	@Autowired
//	protected SessionRegistry sessionregisry;
	
	@Autowired
	Employeeservice empservice;
	
	@Autowired
	public void cofiguerGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(empservice);
	}
	
	
//	@Bean
//	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.authorizeHttpRequests().requestMatchers("/test/**").authenticated().and()
//		.authorizeHttpRequests().requestMatchers("/dashboard/**").authenticated().and()
//		.authorizeHttpRequests().requestMatchers("/admin/**").authenticated()
//		.requestMatchers("/**").permitAll().and().formLogin().loginPage("/Login").permitAll().loginProcessingUrl("/login").defaultSuccessUrl("/dashboard")
//		.permitAll();
//		
//		return http.build();
//	}
	
	

	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		
		http
		   .authorizeHttpRequests()
				.requestMatchers("/dashboard").hasAnyAuthority("Admin","Manager","Employee")
				.requestMatchers("/Admindashboard/**").hasAuthority("Admin")
				.requestMatchers("/Managerdashboard/**").hasAuthority("Manager")
				.requestMatchers("/Userdashboard/**").hasAuthority("Employee")
				.requestMatchers("/**").permitAll()
				.and().formLogin().loginPage("/Login").permitAll().loginProcessingUrl("/login").defaultSuccessUrl("/dashboard").permitAll()
				.and()
		.sessionManagement()
		.maximumSessions(1)
		.maxSessionsPreventsLogin(true)
		.sessionRegistry(sessionRegistry());
		
			
			
//		
//		http.sessionManagement()
//		.sessionFixation()
//		.newSession()
//		.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//		.invalidSessionUrl("/Login?invalid-session=true");
		
		return http.build();
		
		
	
}
	
	@Bean
	SpringSessionBackedSessionRegistry<S> sessionRegistry(){
		return new SpringSessionBackedSessionRegistry<>(this.sessionRepo);
	}
	
//	
//	@Bean
//	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception    {
//		http
//		.authorizeHttpRequests()
//		.requestMatchers("/test/").authenticated()
//		.requestMatchers("/**").permitAll()
//		.and().formLogin().loginPage("/Login").permitAll().loginProcessingUrl("/login").defaultSuccessUrl("/dashboard").permitAll()
//		.and()
//		.sessionManagement()
//		.invalidSessionUrl("/Login?invalid-session=true");
//		 
//		return http.build();
//	}
	
//	
	@Bean
    PasswordEncoder getPE(){ // by default the number of rounds are 10
        return new BCryptPasswordEncoder(); // you need to make sure that the data present with you should be in this format
    }
}


