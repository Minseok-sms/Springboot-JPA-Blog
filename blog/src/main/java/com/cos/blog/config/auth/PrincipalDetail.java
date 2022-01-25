package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;


// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행후 완료시 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션저장소에 저장해줌.

public class PrincipalDetail implements UserDetails {
		private User user;

		@Override
		public String getPassword() {
			
			return user.getPassword();
			
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return user.getUsername();
		}

		
		//계정이 만료되었는지 아닌지 확인후 리턴. (true : 만료 x)
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		
		
		//계정이 잠겨있는지. true : 잠김x
		
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		
		//비밀번호 만료되었는지
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		// 계정이 활성화인지 리턴한다. true
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {

			Collection<GrantedAuthority> collectors = new ArrayList<>();
			collectors.add(() -> {
				return "ROLE_" + user.getRole();
			});
			return collectors;
		}
		
		
}