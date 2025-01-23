package com.SpringBoot.SpringBoot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SecurityConfig {
	
//    @Value("${spring.profiles.active}")
//    private String activeProfile;
//    
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> {
//            	if ("dev".equals(activeProfile)) {
//                    // Swagger 관련 경로 허용
//            		auth.requestMatchers(
//                    		new AntPathRequestMatcher("/v3/api-docs/**"), 
//                    		new AntPathRequestMatcher("/swagger-ui/**"), 
//                    		new AntPathRequestMatcher("/swagger-ui.html")).permitAll();
//                    // 나머지 모든 요청은 인증 필요
//                }
//                auth.anyRequest().authenticated();
//            });
//
//        http.csrf().disable();
//        return http.build();
//    }
    
//    @Bean
//    public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
//        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
//    }
}
