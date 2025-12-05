// package com.example.backend.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.example.backend.security.JwtRequestFilter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     private final JwtRequestFilter jwtRequestFilter;

//     public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
//         this.jwtRequestFilter = jwtRequestFilter;
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//             .authorizeRequests()
//             .antMatchers("/login", "/register").permitAll()
//             .antMatchers("/admin/**").hasRole("ADMIN")
//             .anyRequest().authenticated()
//             .and()
//             .addFilterBefore(new JwtRequestFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
//     }
// }

