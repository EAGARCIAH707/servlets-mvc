/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andevs.crudmvc.controller;

import com.andevs.crudmvc.model.dao.alumno.AlumnoDao;
import com.andevs.crudmvc.model.dao.alumno.IAlumnoDao;
import com.andevs.crudmvc.model.entities.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private IAlumnoDao alumnoDao;

    private void getDaoInstance() {
        if (this.alumnoDao == null) {
            alumnoDao = new AlumnoDao();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getDaoInstance();
        Alumno alumno = new Alumno();
        alumno.setNombre(request.getParameter("name"));
        alumno.setIdentificacion(request.getParameter("id_number"));
        alumno.setCorreo(request.getParameter("email"));
        alumno.setNombreUsuario(request.getParameter("username"));
        alumno.setContrasenna(request.getParameter("password"));
        alumno.setTelefono(request.getParameter("phone"));
        Boolean result = alumnoDao.create(alumno);

        PrintWriter out = response.getWriter();
        if (result) {
            out.println("<html>");
            out.println("Usuario ingresado con exito");
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
