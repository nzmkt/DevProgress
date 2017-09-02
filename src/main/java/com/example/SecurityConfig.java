package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@EnableWebSecurity	// 1基本的な設定をするクラスにつける。
public class SecurityConfig extends WebSecurityConfigurerAdapter {	// 2継承したい箇所だけoverrideして設定できる。
	
	@Override
	public void configure(WebSecurity web) throws Exception {	// 3overrideすることで特定のリクエストに対して設定を無視するなど全体にかかわる設定ができる。
		web.ignoring().antMatchers("/webjars/**", "/css/**");	// 	4静的リソースに対するアクセスには「セキュリティ」のせっていは無視するようにする。
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {	// 5overrideすることで認可の設定やログインログアウトに関する設定ができる。
		
		http
			// 6認可に関する設定。「/loginForm」には任意のユーザーがアクセスできるようにする。それ以外のパスには認証なしでアクセスできないようにする。
			.authorizeRequests().antMatchers("/loginForm").permitAll().anyRequest().authenticated()
			// 7「ログイン」に関する設定。
			.and().formLogin().loginProcessingUrl("/login").loginPage("/loginForm").failureUrl("/loginForm?error").defaultSuccessUrl("/customers",  true)
				.usernameParameter("username").passwordParameter("password")
			// 8「ログアウト」に関する設定。
			.and().logout().logoutSuccessUrl("/loginForm");
		
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new Pbkdf2PasswordEncoder();	// 9パスワードをハッシュ化するための定義。推奨されている「PBKDF2アルゴリズム」を設定。
	}
}