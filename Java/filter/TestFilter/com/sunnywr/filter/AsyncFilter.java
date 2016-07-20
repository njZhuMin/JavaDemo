package com.sunnywr.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AsyncFilter", value = {"/index.jsp"},
        asyncSupported = true, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.ASYNC})
public class AsyncFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Start AsyncFilter...");
        chain.doFilter(request, response);
        System.out.println("End AsyncFilter...");
    }

    public void destroy() {

    }
}
