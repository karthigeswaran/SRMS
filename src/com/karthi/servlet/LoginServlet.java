package com.karthi.servlet;

import com.google.gson.Gson;
import com.karthi.model.User;

import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet{
    private final static User admin = new User("admin","admin");
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String body = request.getReader().readLine();
        Gson gson = new Gson();
        User user = gson.fromJson(body, User.class);
        if(user.isUser(admin)){
            HttpSession session = request.getSession();
            session.setAttribute("user","admin");
            session.setMaxInactiveInterval(2*60);
            response.addHeader("redirect","home.html");
            //redirect to home page
        }else {
            //response header add
            response.setStatus(401);
        }
    }
}

