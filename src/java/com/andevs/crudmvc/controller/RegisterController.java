/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andevs.crudmvc.controller;

import com.andevs.crudmvc.model.dao.product.ProductDao;
import com.andevs.crudmvc.model.dao.product.IProductDao;
import com.andevs.crudmvc.model.entities.Producto;
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

    private IProductDao productDao;

    private void getDaoInstance() {
        if (this.productDao == null) {
            productDao = new ProductDao();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        getDaoInstance();
        Producto producto = new Producto();
        producto.setNombre(request.getParameter("name"));
        producto.setPrecio(Double.parseDouble(request.getParameter("price")));
        producto.setUnidades(Integer.parseInt(request.getParameter("units")));

        Boolean result = productDao.create(producto);

        PrintWriter out = response.getWriter();
        if (result) {
            out.println("<html>");
            out.println("Producto ingresado con exito");
            out.println("<a href=\"/crud-mvc/\">Ver tabla</a>");
            out.println("</html>");
            out.close();

        } else {
            out.println("<html>");
            out.println("<title>Error</title>");
            out.println("<a href=\"/crud-mvc/\">Ver tabla</a>");
            out.println("Datos invalidos");
            out.println("</html>");
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
