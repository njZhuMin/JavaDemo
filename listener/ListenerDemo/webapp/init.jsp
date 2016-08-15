<%@ page import="com.sunnywr.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>init</title>
</head>
<body>
    <%
        request.setAttribute("requestName", "requestValue");
        request.getSession().setAttribute("sessionName", "sessionValue");
        request.getSession().getServletContext().setAttribute("contextName", "contextValue");

        request.getSession().setAttribute("currentUser", new User());
    %>
    Init attributes...<br/>
    <button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">
        Init
    </button>
    <button onclick="location.href='<%=request.getContextPath()%>/destroy.jsp';">
        Destroy
    </button>
</body>
</html>
