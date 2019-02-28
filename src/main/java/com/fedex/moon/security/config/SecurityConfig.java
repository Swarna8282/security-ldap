package com.fedex.moon.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure (HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
			.anyRequest().fullyAuthenticated()
			.and()
			.formLogin();
	}
	
	@Override
	protected void configure (AuthenticationManagerBuilder builder) throws Exception {
		builder.ldapAuthentication()
			.userDnPatterns("uid={0}, ou=people")
			.groupSearchBase("ou=groups")
			.contextSource().url("ldap://localhost:8389/dc=springframework,dc=org")
			.and()
			.passwordCompare()
//			.passwordEncoder(new LdapShaPasswordEncoder()) //ben:benspassword works only if this encoder is there as the userPassword value for ben in the ldif file is encoded as "{SHA}nFCebWjxfaLbHHG1Qk5UU4trbvQ="
			.passwordAttribute("userPassword");
		
		// valid users for this are: cat:catspassword, bob:bobspassword
	}
}
