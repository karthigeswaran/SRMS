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
            Class.forName(JDBC_driver);
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
            statement = connection.createStatement();
            command = "INSERT INTO student "+
                    "VALUE ("+
                    student.getName()+","+
                    student.getClassName()+","+
                    student.getSection()+","+
                    Date.valueOf(student.getDob())+","+
                    student.getRollNo()+");";
            int rowCount = statement.executeUpdate(command);
            if(rowCount==0) {
                closeConnection();
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        closeConnection();
        return true;
    }

    private Boolean closeConnection(){
        try{

            if(statement!=null){
                statement.close();
            }

            if(connection!=null){
                connection.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
