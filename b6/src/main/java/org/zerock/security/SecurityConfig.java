package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.zerock.persistence.MemberRepository;

import lombok.Setter;
import lombok.extern.java.Log;

@EnableGlobalMethodSecurity(prePostEnabled = true)
//메소드의 pre post 잡아줌(이거 안넣으면 컨트롤러 @PreAuthorize 활성화못시킴)
@Log
@EnableWebSecurity
// 자바 configration 어노테이션 추가되는거랑 똑같
public class SecurityConfig extends WebSecurityConfigurerAdapter{
									// 메소드를 통해서 세팅잡으려고

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		log.info("=============================================");
		log.info("configure");
		log.info("=============================================");
		// 이 메소드 안넣으면 all페이지도 로그인체크걸림(super에 걸림)
	
		http.formLogin();
		// access denied 걸리면  로그인페이지 갈거라고 선언
		
		http.rememberMe().tokenValiditySeconds(60*60*24);
		
	}	

	
	@Bean
	public UserDetailsService userDetailsService() {
		// Zerockuserservice를 빈으로 설정
		return new ZerockUserService();
	}
	
}
