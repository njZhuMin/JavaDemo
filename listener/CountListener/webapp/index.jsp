<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sunnywr.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    Current online user number: ${userNumber} <br/>
    <%
        ArrayList<User> userList = (ArrayList<User>)
                request.getServletContext().getAttribute("userList");
        if(userList != null) {
            for(int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);

    %>
    IP: <%=user.getIpString()%>, FirstTime: <%=user.getFirstTimeString()%>, SessionId: <%=user.getSessionIdString()%> <br/>
    <%}}%>
</body>
</html>
