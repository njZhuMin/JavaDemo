package com.sunnywr.listener;

import com.sunnywr.entity.User;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import com.sunnywr.util.SessionUtil;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    private int userNumber = 0;

    public void sessionCreated(HttpSessionEvent se) {
        userNumber++;
        se.getSession().getServletContext().setAttribute("userNumber", userNumber);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        userNumber--;
        se.getSession().getServletContext().setAttribute("userNumber", userNumber);

        ArrayList<User> userList = null;
        userList = (ArrayList<User>)se.getSession().
                getServletContext().getAttribute("userList");
        if(SessionUtil.getUserBySessionId(userList, se.getSession().getId()) != null)
            userList.remove(SessionUtil.getUserBySessionId(userList, se.getSession().getId()));
    }
}
