package com.andevs.crudmvc.controller;

import com.andevs.crudmvc.model.dao.login.ILoginDao;
import com.andevs.crudmvc.model.dao.login.LoginDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    private ILoginDao loginDao;

    private void getDaoInstance() {
        if (this.loginDao == null) {
            loginDao = new LoginDao();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getDaoInstance();
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean result = loginDao.login(username, password);
        PrintWriter out = response.getWriter();
        if (result) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
            rd.forward(request, response);
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
    }//
}
