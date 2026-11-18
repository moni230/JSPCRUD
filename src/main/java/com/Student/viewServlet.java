package com.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

// reaches this servlet, after jsp provides the request from user.
    @WebServlet("/viewStudent")
    public class viewServlet extends HttpServlet {

        @Override
        // this method accepts both req & resp
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            resp.setContentType("text/plain");

            // used to print content on the webpage.
            PrintWriter out = resp.getWriter();

            try {
                // create the instance of StudentDAO class. (StudentDAO -> deals with database operation).
                StudentDAO studentdao = new StudentDAO();

                // calls the viewStudents method in StudentDAO class.
                studentdao.viewStudents(resp.getWriter());

                // handles the possible exceptions.
            } catch (SQLException | ClassNotFoundException  e) {
                out.println("Database error occurred!");
                e.printStackTrace();
            }
            // handle custom exception
            catch (GlobalException e) {
                out.println(e.getMessage());

                // handle NumberFormatException
            }catch (NumberFormatException  e) {
                out.println("Enter a Valid number!");
            }
        }
    }

