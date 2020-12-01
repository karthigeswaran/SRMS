package com.karthi.servlet;

import com.google.gson.Gson;
import com.karthi.record.Student;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
         String str = request.getReader().readLine();
         Gson gson = new Gson();
         Student student = gson.fromJson(str,Student.class);
        response.getOutputStream().print("successful");
        //HttpSession session = request.getSession();


    }
}

