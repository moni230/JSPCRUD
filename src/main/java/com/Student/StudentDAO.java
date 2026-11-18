package com.Student;
import java.io.PrintWriter;
import java.sql.*;

public class StudentDAO {

    // Add the student details with the parameter values.
    public void addStudent(int id, String name, String phone, String department, String gender) throws SQLException, ClassNotFoundException {

        // checks if there is any duplicate id exists.
        if (StudentIdExists(id)) {
            // if exists, handle custom exception.
            throw new GlobalException("Id already existed, kindly enter another id");

        }
      // if not, proceed with  SQL insert query (with JDBC Connection).
        Connection con = DBConnection.getConnection();

        // create a query
        String query = "INSERT INTO student(id, name, phone_Number, department,gender) VALUES(?,?,?,?,?)";

        //prepare a statement that holds sql query.
        PreparedStatement ps = con.prepareStatement(query);

        // set values to the placeholder with respective db columns.
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, phone);
        ps.setString(4, department);
        ps.setString(5, gender);

        // insert the values to the db by executeUpdate() method.
        int rows = ps.executeUpdate();

    }

     // view students module
    public void viewStudents(PrintWriter writer) throws SQLException, ClassNotFoundException {

        // create a query
        String query = "SELECT * FROM student";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        // set boolean value
        boolean hasRecords = false;
        writer.println("Welcome to view Students Portal!");
        writer.println("---------------------------------");

        while (rs.next()) {

            // if result contains rows, change status into true.
            hasRecords = true;

            writer.println("ID: " + rs.getInt("id"));
            writer.println("NAME: " + rs.getString("Name"));
            writer.println("PHONE NUMBER: " + rs.getString("Phone_Number"));
            writer.println("DEPARTMENT: " + rs.getString("Department"));
            writer.println("GENDER: " + rs.getString("Gender"));

            writer.println("---------------------------");
        }

        // if there is no rows found, throw this custom message.
        if (!hasRecords) {
            writer.println("No Records Found!");
        }

    }

   // update module.
    public boolean updateStudents(int id, String name, String phoneNumber, String department, String gender) throws SQLException, ClassNotFoundException {

        // set status to false.
        boolean status = false;

        // pass the sql query
        String query = "UPDATE student SET name = ?, phone_number = ?, department = ?, gender = ? WHERE id = ?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(query);

        // set values to respective db columns.
        ps.setString(1, name);
        ps.setString(2, phoneNumber);
        ps.setString(3, department);
        ps.setString(4, gender);
        ps.setInt(5, id);

        int rows = ps.executeUpdate();


        if (rows == 0) {
            // if no rows found, handle custom exception.
            throw new GlobalException("Student details with this " + id + " is not existed!");
        }

        //if not, set the status as true and proceed accordingly.
        else {
            status = true;
        }
        return status;
    }


    // delete module
    public boolean deleteStudents(int id) throws SQLException, ClassNotFoundException {

        boolean status = false;

        // pass sql query
        String query = "DELETE FROM student WHERE id =?";
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        int rows = ps.executeUpdate();

        if (rows == 0) {
            // if no student id found, handle custom exception.
            throw new GlobalException("Student details with this " + id + " is not existed!");

        }
        // if not, proceed with accordingly(status to true, enables to update values).
        else {
            status = true;
        }
        return status;
    }


    // check the duplicate id exists.
    public boolean StudentIdExists(int id) throws SQLException, ClassNotFoundException {

        boolean status = false;

        // count the same id values.
        String sqlQuery = "SELECT COUNT(*) FROM Student WHERE id =?";

        Connection con = DBConnection.getConnection();

        PreparedStatement cs = con.prepareStatement(sqlQuery);

        cs.setInt(1, id);

        ResultSet rs = cs.executeQuery();

        while (rs.next()) {

            // if count morethan 0, duplicate exists, prevents insertion of duplicate id.
            if (rs.getInt(1) > 0) {
                status = true;
            }
        }
        return status;

    }
}





