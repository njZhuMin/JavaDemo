<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    Index page.<br/>
    currentUser : <%=request.getSession().getAttribute("currentUser") %><br/>
    <button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">
        Init
    </button>
    <button onclick="location.href='<%=request.getContextPath()%>/destroy.jsp';">
        Destroy
    </button>
</body>
</html>
