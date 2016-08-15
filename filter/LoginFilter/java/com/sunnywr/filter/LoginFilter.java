package com.sunnywr.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", value = {"/*"},
    initParams = {
        @WebInitParam(name = "noFilterPath", value = "login.jsp;fail.jsp;servlet"),
        @WebInitParam(name = "charset", value = "UTF-8")})
public class LoginFilter implements Filter {
    private FilterConfig config;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();

        String charset = config.getInitParameter("charset");
        //未指定则使用默认编码
        if(charset == null)
            charset = "UTF-8";
        request.setCharacterEncoding(charset);

        String noFilterPath = config.getInitParameter("noFilterPath");
        if(noFilterPath != null) {
            String[] strArray = noFilterPath.split(";");
            for(String path : strArray) {
                if(path == null || "".equals(path))
                    continue;
                if(request.getRequestURL().indexOf(path) != -1) {
                    chain.doFilter(req, resp);
                    return;
                }
            }
        }

        if(session.getAttribute("username") != null) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
