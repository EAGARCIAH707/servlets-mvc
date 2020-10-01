package com.andevs.crudmvc.controller;

import com.andevs.crudmvc.model.dao.tutorias.ITutoriasDao;
import com.andevs.crudmvc.model.dao.tutorias.TutoriasDao;
import com.andevs.crudmvc.model.entities.Tutorias;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TutoriasController", urlPatterns = {"/TutoriasController"})
public class TutoriasController extends HttpServlet {
    private ITutoriasDao tutoriasDao;

    private void getDaoInstance() {
        if (this.tutoriasDao == null) {
            this.tutoriasDao = new TutoriasDao();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getDaoInstance();
        List<Tutorias> list = tutoriasDao.getAllTutorias();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        request.setAttribute("list", list);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/tutorias.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
