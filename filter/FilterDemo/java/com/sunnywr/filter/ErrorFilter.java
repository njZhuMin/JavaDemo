package com.sunnywr.filter;

import javax.servlet.*;
import java.io.IOException;

public class ErrorFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Error path");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
