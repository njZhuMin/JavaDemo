package com.sunnywr.listener;

import com.sunnywr.entity.User;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.sunnywr.util.SessionUtil.getUserBySessionId;
@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    private ArrayList<User> userList;   //在线用户List

    public void requestDestroyed(ServletRequestEvent sre) {

    }

    public void requestInitialized(ServletRequestEvent sre) {
        userList = (ArrayList<User>) sre.getServletContext().getAttribute("userList");
        if(userList == null)
            userList = new ArrayList<User>();

        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        String sessionIdString = request.getSession().getId();
        if(getUserBySessionId(userList, sessionIdString) == null) {
            User user = new User();
            user.setSessionIdString(sessionIdString);
            user.setFirstTimeString(new
                    SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user.setIpString(request.getRemoteAddr());
            userList.add(user);
        }
        sre.getServletContext().setAttribute("userList", userList);
    }

}
