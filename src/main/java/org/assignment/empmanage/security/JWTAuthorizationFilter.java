/*
"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation API Service

    @Description - JWT Authorization Filter
"""
*/

package org.assignment.empmanage.security;

import io.jsonwebtoken.Jwts;
import org.assignment.empmanage.applicationuser.ApplicationUser;
import org.assignment.empmanage.applicationuser.ApplicationUserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static org.assignment.empmanage.security.SecurityConstant.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    //private final ApplicationUserService applicationUserService;

    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_STRING);
        if(header == null || !header.startsWith(TOKEN_PREFIX)){
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuth = getAuthenticationToken(request);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuth);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if(token == null) return null;
        String user  = Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();
        //UserDetails userDetails = applicationUserService.loadUserByUsername(username);
        //ApplicationUser applicationUser = applicationUserService.loadApplicationUserByUsername(username);
        return user  !=  null? new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>()) : null;
    }
}
