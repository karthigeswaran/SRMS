package com.karthi.servlet;

import com.google.gson.Gson;
import com.karthi.handler.StudentRecordHandler;
import com.karthi.model.Student;

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
        StudentRecordHandler studentRecordHandler = new StudentRecordHandler();
        if(studentRecordHandler.createStudent(student)){
            response.setStatus(200);
            response.getOutputStream().print("New student record successfully created");
        }else{
            response.setStatus(400);
            response.getOutputStream().print("Record not created");
        }

    }
}

