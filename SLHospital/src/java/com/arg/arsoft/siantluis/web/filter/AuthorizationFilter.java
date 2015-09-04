/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author anawatj
 */
@Component
public class AuthorizationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // remove context path
        String inputPath = request.getRequestURI().replaceFirst("^/[^\\/]+/", "/");

        // if not a page request, skip filter
     if (inputPath.matches("^/resources/.+") || !inputPath.matches("^/*.+\\.html(\\?.*)?")
                || inputPath.matches("^/(index|error|unauthorized|login)\\.html(\\?.*)?")) {
            chain.doFilter(request, response);
            return;
        }
        //System.out.println("page request: " + inputPath);

        // if not a authenticated request, return unauthorized error.
       if (SecurityContextHolder.getContext().getAuthentication() == null
                || !SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            System.out.println("not a authenticated request, return unauthorized error.");
            response.setStatus(403);
            response.sendRedirect(request.getContextPath() + "/unauthorized.html");
            return;
        } else {
            Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            // if userDetails can't be read, return unauthorized error.
            if (userDetails == null || !(userDetails instanceof UserDetails)) {
                System.out.println("userDetails can't be read, return unauthorized error.");
                response.setStatus(403);
                response.sendRedirect(request.getContextPath() + "/unauthorized.html");
                return;
            } else {
                UserDetails user = (UserDetails) userDetails;
               /*  boolean result = authorizationService.isAuthorizedByUser("ZO002", user.getUsername(), inputPath, null,
                 null, null, null);*/
               //  System.out.println("is user " + user.getUsername() + " Authorized?: " + result);

                 // if user is not authorized, return unauthorized error.
               /*  if (!result && !user.getUsername().equals("ANANC")) {
                 System.out.println("user is not authorized, return unauthorized error.");
                 response.setStatus(403);
                 response.sendRedirect(request.getContextPath() + "/unauthorized.html");
                 return;*/
            }
        }
        chain.doFilter(request, response);
    }

}
