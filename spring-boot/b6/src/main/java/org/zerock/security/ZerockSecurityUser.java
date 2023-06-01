package org.zerock.security;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.Member;

import lombok.Data;

@Data
public class ZerockSecurityUser extends User{

	private Member member;
	
	public ZerockSecurityUser(Member member) {
		super(member.getMid(), member.getMpw(), 
			
			member.getAuthList().stream()
			.map(auth -> new SimpleGrantedAuthority("ROLE_"+auth.getAuth()))
			// 다른 타입으로 바꿔줌 : mapping
			.collect(Collectors.toList())
			//각각의 auth가 SimpleGrantedAuthority로 바뀜
		);
		
		this.member = member;
	}	

}
