package com.company.filter;

import com.company.service.UserService;
import com.company.util.SpringSecurityJwtUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)

public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private SpringSecurityJwtUtil jwtUtil;
    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
            if (handleCors(httpServletRequest, httpServletResponse, true))
                return;

            String authHolder = httpServletRequest.getHeader("Authorization");
            String token = null;
            String email = null;
            if (authHolder != null && authHolder.startsWith("Bearer ")) {
                token = authHolder.substring(7);

                try {
                    email = jwtUtil.extractEmail(token);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                UserDetails userDetails = userService.loadUserByUsername(email);

                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // if (jwtUtil.validateToken(token, userDetails)) {

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    // }
                } else {
                    System.out.println("Token is not validated");
                }

            }


            filterChain.doFilter(httpServletRequest, httpServletResponse);
        handleCors(httpServletRequest, httpServletResponse, false);


        }


    private boolean handleCors(HttpServletRequest request, HttpServletResponse response, boolean options) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Content-Type, Authorization");
        response.setStatus(200);
        return (options && request.getMethod().equalsIgnoreCase("OPTIONS"));
    }


}

