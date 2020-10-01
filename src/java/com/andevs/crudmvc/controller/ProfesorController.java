package com.andevs.crudmvc.controller;

import com.andevs.crudmvc.model.dao.profesor.IProfesorDao;
import com.andevs.crudmvc.model.dao.profesor.ProfesorDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfesorController", urlPatterns = {"/ProfesorController"})
public class ProfesorController extends HttpServlet {

    private IProfesorDao profesorDao;

    private void getDaoInstance() {
        if (this.profesorDao == null) {
            profesorDao = new ProfesorDao();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getDaoInstance();
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String idNumber = request.getParameter("id_number");

        Boolean result = profesorDao.createTeacher(name, idNumber);
        PrintWriter out = response.getWriter();
        if (result) {
            out.println("<html>");
            out.println("<title>Concertar Tutoria</title>");
            out.println("Profesor ingresado con exito");
            out.println("</html>");
            out.close();

        } else {
            out.println("<html>");
            out.println("<title>Concertar Tutoria</title>");
            out.println("Datos inavlidos");
            out.println("</html>");
            out.close();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profesor.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }//
}
