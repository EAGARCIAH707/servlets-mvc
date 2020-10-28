/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andevs.crudmvc.controller;

import com.andevs.crudmvc.model.dao.product.ProductDao;
import com.andevs.crudmvc.model.dao.product.IProductDao;
import com.andevs.crudmvc.model.entities.Producto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lenovo
 */
@WebServlet(name = "EditStudent", urlPatterns = {"/EditStudent"})
public class EditStudent extends HttpServlet {
    
    private IProductDao alumnoDao;
    
    private void getDaoInstance() {
        if (this.alumnoDao == null) {
            alumnoDao = new ProductDao();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        getDaoInstance();
        Producto data = alumnoDao.findById(id);
        HttpSession session = request.getSession();
/*        session.setAttribute("id", data.getIdAlumno());
        session.setAttribute("name", data.getNombre());
        session.setAttribute("id_number", data.getIdentificacion());
        session.setAttribute("email", data.getCorreo());
        session.setAttribute("password", data.getContrasenna());
        session.setAttribute("phone", data.getTelefono());
        session.setAttribute("username", data.getNombreUsuario());*/
        
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("data", data);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/editStudent.jsp");
        rd.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getDaoInstance();
        Producto producto = new Producto();
/*        producto.setIdAlumno(Integer.parseInt(request.getParameter("id")));
        producto.setNombre(request.getParameter("name"));
        producto.setIdentificacion(request.getParameter("id_number"));
        producto.setCorreo(request.getParameter("email"));
        producto.setNombreUsuario(request.getParameter("username"));
        producto.setContrasenna(request.getParameter("password"));
        producto.setTelefono(request.getParameter("phone"));*/
        Boolean result = alumnoDao.update(producto);
        
        PrintWriter out = response.getWriter();
        if (result) {
            out.println("<html>");
            out.println("Usuario actualizado con exito");
            out.println("<a href=\"/crud-mvc/EstudentTableController\">Ver tabla</a>");
            out.println("</html>");
            out.close();
            
        } else {
            out.println("<html>");
            out.println("<title>No fue posible actualizar</title>");
            out.println("No fue posible actualizar");
            out.println("<a href=\"/crud-mvc/EstudentTableController\">Ver tabla</a>");
            out.println("</html>");
            out.close();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
