package com.karthi.handler;

import com.karthi.model.Student;

import java.sql.*;

public class StudentRecordHandler {
    static final String JDBC_driver  = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/schooldb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    private Connection connection = null;
    private Statement statement = null;
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
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    private void openConnection(){
        try{
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
