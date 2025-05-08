package se.mete.javawebdemo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private CustomOAuth2UserService customOauth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request
                // Public routes that do not require authentication
                .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/api/v1/auth/**", "/login/**", "/oauth_login*", "/oauth2/authorization/**")
                .permitAll()

                // Protect /profile by requiring authentication
                .requestMatchers("/profile").authenticated()

                // Protect any other routes with authentication
                .anyRequest().authenticated());

        // Disable CSRF and CORS for this application (can be enabled for production)
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))

                // OAuth2 login configuration
                .oauth2Login(oauth2 -> {
                    oauth2.userInfoEndpoint(userInfo -> userInfo.userService(customOauth2UserService));

                    // After successful login, redirect to /profile
                    oauth2.successHandler((request, response, authentication) -> {
                        response.sendRedirect("/profile");
                    });
                });

        return http.build();
    }
}
