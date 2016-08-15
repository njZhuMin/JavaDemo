package com.sunnywr.util;

import com.sunnywr.entity.User;
import java.util.ArrayList;

public class SessionUtil {

    public static Object getUserBySessionId(ArrayList<User> userList, String sessionIdString) {
        for(int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if(sessionIdString.equals(user.getSessionIdString()))
                return user;
        }
        return null;
    }
}
