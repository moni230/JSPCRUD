package com.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/updateStudent")
public class updateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get the input from user via getParameter() method.
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String department = req.getParameter("department");
        String gender = req.getParameter("gender");

        // to print values on the web.
        PrintWriter out = resp.getWriter();


        try {
            StudentDAO studentDAO = new StudentDAO();

            //calls the update method in DAO class.
            studentDAO.updateStudents(Integer.parseInt(id), name, phoneNumber, department, gender);

            // confirmation message, once details are updated.
            out.println("Student details are updated successfully!");

            // handles all the possible exceptions.
        } catch (NumberFormatException e) {

            out.println("Please enter a valid student ID.");

        } catch (GlobalException e) {

            out.println(e.getMessage());

        } catch (SQLException | ClassNotFoundException e) {

            out.println("Database error occurred!");
            e.printStackTrace();


        }
    }
}
