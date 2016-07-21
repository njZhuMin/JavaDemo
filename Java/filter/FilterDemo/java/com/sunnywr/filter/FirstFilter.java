package com.sunnywr.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init FirstFilter");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Start doFilter FirstFilter...");
        //chain.doFilter(request, response);

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        //redirect
        res.sendRedirect(req.getContextPath() + "/main.jsp");
        //forward
        //req.getRequestDispatcher("main.jsp").forward(req, res);
        System.out.println("End doFilter FirstFilter...");
    }

    public void destroy() {
        System.out.println("destroy FirstFilter");
    }
}
