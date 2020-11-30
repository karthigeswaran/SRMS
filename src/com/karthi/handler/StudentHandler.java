package com.karthi.handler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentHandler extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
         String str = request.getReader().readLine();
        //GsonBuilder builder = new GsonBuilder();
        //builder.setPrettyPrinting();
        //Gson gson = builder.create();
        //User user = gson.fromJson(str,User.class);
        response.getOutputStream().print("successful");
        //HttpSession session = request.getSession();


    }
}

