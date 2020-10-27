/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andevs.crudmvc.controller;

import com.andevs.crudmvc.model.dao.alumno.AlumnoDao;
import com.andevs.crudmvc.model.dao.alumno.IAlumnoDao;
import com.andevs.crudmvc.model.dao.login.ILoginDao;
import com.andevs.crudmvc.model.dao.login.LoginDao;
import com.andevs.crudmvc.model.entities.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "EstudentTableController", urlPatterns = {"/EstudentTableController"})
public class EstudentTableController extends HttpServlet {
    private IAlumnoDao alumnoDao;

    private void getDaoInstance() {
        if (this.alumnoDao == null) {
            alumnoDao = new AlumnoDao();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getDaoInstance();
        List<Alumno> list = alumnoDao.findAll();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        request.setAttribute("list", list);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/studentsTable.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
