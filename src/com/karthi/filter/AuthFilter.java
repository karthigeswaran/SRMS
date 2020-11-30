package com.karthi.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();
        if(session==null && !(uri.endsWith("login.html") || uri.endsWith("login") || uri.endsWith(".js") || uri.endsWith(".css"))){
            res.sendRedirect("/SRMS/login.html");
        }else{
            chain.doFilter(request,response);
        }
    }
}
