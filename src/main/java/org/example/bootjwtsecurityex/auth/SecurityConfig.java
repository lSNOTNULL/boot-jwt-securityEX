package org.example.bootjwtsecurityex.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 이 클래스는 설정 파일이다
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf
                        -> csrf
                        .ignoringRequestMatchers("/api/**"))
                .authorizeHttpRequests(
                        auth
                        ->auth
                                        .requestMatchers("api/**","/swagger-ui/**","/v3/api-docs/**") // 여러개 한번에 넣어도 가능.
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated())
                .formLogin(Customizer.withDefaults()
                )
                .logout(Customizer.withDefaults());
        return http.build();
    }
}
