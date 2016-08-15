package com.sunnywr.filter;

import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init SecondFilter");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Start doFilter SecondFilter...");
        chain.doFilter(request, response);
        System.out.println("End doFilter SecondFilter...");
    }

    public void destroy() {
        System.out.println("destroy SecondFilter");
    }
}
