package com.karthi.handler;

import com.karthi.model.Student;

import java.sql.*;

public class StudentRecordHandler {
    static final String JDBC_driver  = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/srms";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    private Connection connection = null;
    private Statement statement = null;
    private String command = "";

    private void openConnection(){
        try{
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public StudentRecordHandler(){
        openConnection();
    }

    public boolean createStudent(Student student){
        if(connection == null){
            return false;
        }
        try{
            connection.setAutoCommit(false);
            Savepoint savepoint = connection.setSavepoint();
            statement = connection.createStatement();
            command = "INSERT INTO student "+
                    "VALUE ("+
                    student.getName()+","+
                    student.getClassName()+","+
                    student.getSection()+","+
                    Date.valueOf(student.getDob())+","+
                    student.getRoll_no()+");";
            int rowCount = statement.executeUpdate(command);
            if(rowCount==0){
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
