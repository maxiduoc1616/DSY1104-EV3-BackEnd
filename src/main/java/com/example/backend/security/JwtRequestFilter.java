// package com.example.backend.security;

// import org.springframework.web.filter.OncePerRequestFilter;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRequest;
// import javax.servlet.ServletResponse;
// import javax.servlet.http.HttpServletRequest;
// import java.io.IOException;
// import java.util.List;
// import java.util.stream.Collectors;

// public class JwtRequestFilter extends OncePerRequestFilter {

//     private JwtUtil jwtUtil;

//     public JwtRequestFilter(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, ServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//         String token = getJwtFromRequest(request);

//         if (token != null && jwtUtil.validateToken(token)) {
//             String username = jwtUtil.extractUsername(token);
//             List<String> roles = jwtUtil.extractRoles(token);

//             UsernamePasswordAuthenticationToken authentication =
//                 new UsernamePasswordAuthenticationToken(username, null, roles.stream()
//                 .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
//                 .collect(Collectors.toList()));

//             SecurityContextHolder.getContext().setAuthentication(authentication);
//         }

//         filterChain.doFilter(request, response);
//     }

//     private String getJwtFromRequest(HttpServletRequest request) {
//         String header = request.getHeader("Authorization");
//         if (header != null && header.startsWith("Bearer ")) {
//             return header.substring(7);
//         }
//         return null;
//     }
// }
