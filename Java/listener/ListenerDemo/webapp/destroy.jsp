<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>destroy</title>
</head>
<body>
    <%
        request.removeAttribute("requestName");
        request.getSession().removeAttribute("sessionName");
        request.getSession().getServletContext().removeAttribute("contextName");

        request.getSession().removeAttribute("currentUser");
    %>
    Destroy attributes...<br/>
    <button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">
        Init
    </button>
    <button onclick="location.href='<%=request.getContextPath()%>/destroy.jsp';">
        Destroy
    </button>
</body>
</html>
