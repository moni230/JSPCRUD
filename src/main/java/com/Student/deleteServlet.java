package com.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/deleteStudent")
public class deleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {

           // create the instance of the DAO class.
            StudentDAO studentDAO = new StudentDAO();

            // calls the deletestudent method in DAO class.

            studentDAO.deleteStudents(Integer.parseInt(id));

            out.println("Student details deleted successfully!");


            // Handles all the possible exeception cases.
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