package com.haihaycode.java5.lab7.implement;

import com.haihaycode.java5.lab4.Service.SessionService;
import com.haihaycode.java5.lab5.entity.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    SessionService session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        Account user = session.get("user"); // Get user from session
        String error = "";

        if (user == null) {
            if (uri.startsWith("/account") || uri.startsWith("/admin")) {
                error = "Please login!";
            }
        } else if (!user.isAdmin() && uri.startsWith("/admin")) {
            error = "Access denied!";
        }

        if (error.length() > 0) { // If there's an error
            session.set("security-uri", uri);

            response.sendRedirect("/login?error=" + error); // Redirect to login
            return false;
        }
        return true;
    }
}
