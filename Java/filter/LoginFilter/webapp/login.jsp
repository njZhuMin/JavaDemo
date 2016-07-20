<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="<%=request.getContextPath() %>/servlet/LoginServlet" method="post">
        UserName: <input type="text" name="username" /><br/>
        Password: <input type="password" name="password" /><br/>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
