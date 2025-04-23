package org.example.bootjwtsecurityex.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
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
