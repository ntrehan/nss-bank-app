package com.nss.bank.security;

import com.nss.bank.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin/**", "/admin/register","/admin/login", "/customer/signup", "customer/login","/institutes").permitAll()  // Allow all requests to /admin/**
                        .anyRequest().authenticated()  // Require authentication for all other requests
                )
                .httpBasic(Customizer.withDefaults())  // Enable HTTP Basic Authentication
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

//        return http
//                .cors(AbstractHttpConfigurer::disable)
//
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorize-> authorize.requestMatchers(
//                        "/admin/**",
//                        "/transaction/**",
//                        "/v2/api-docs",
//                        "/v3/api-docs",
//                        "/v3/api-docs/**",
//                        "/swagger-resources",
//                        "/swagger-resources/**",
//                        "/configuration/ui",
//                        "/configuration/security",
//                        "/swagger-ui/**",
//                        "/webjars/**",
//                        "swagger-ui.html"
//                )
//                .permitAll()
//                .anyRequest()
//                .authenticated())
//                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/auth/**").authenticated()).httpBasic(Customizer.withDefaults())
//                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/admin/*").authenticated()
//                            .requestMatchers("/**").permitAll()
////                        .requestMatchers("/admin/*").hasRole("ADMIN")
//                ).httpBasic(Customizer.withDefaults())
//                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
    }

//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService().
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("$2a$04$dSIz4rdSaWWYZ9nooLXEKewSUY3yM5UGMaQN2c6ZjEqwXund0pa1m").roles("ADMIN").and();
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
