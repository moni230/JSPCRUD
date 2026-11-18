package com.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/addStudent")
public class StudentServlet extends HttpServlet {
    StudentDAO studentdao = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get the input from jsp and add the resources into db.

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String department = req.getParameter("department");
        String gender = req.getParameter("gender");

        PrintWriter out = resp.getWriter();

        boolean result = false;

            try {
                StudentDAO studentDAO = new StudentDAO();

                //calls the addstudent method in DAO class by passing paramater values.
                studentDAO.addStudent(Integer.parseInt(id), name, phoneNumber, department, gender);

                out.println("Student details are updated successfully!");

                // Handle all the possible exceptions.

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