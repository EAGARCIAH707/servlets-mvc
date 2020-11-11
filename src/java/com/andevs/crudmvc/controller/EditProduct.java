/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andevs.crudmvc.controller;

import com.andevs.crudmvc.model.dao.product.IProductDao;
import com.andevs.crudmvc.model.dao.product.ProductDao;
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
@WebServlet(name = "EditProduct", urlPatterns = {"/EditProduct"})
public class EditProduct extends HttpServlet {

    private IProductDao productDao;

    private void getDaoInstance() {
        if (this.productDao == null) {
            productDao = new ProductDao();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        getDaoInstance();
        Producto producto = productDao.findById(id);
        HttpSession session = request.getSession();
        session.setAttribute("id", producto.getIdProducto());
        session.setAttribute("name", producto.getNombre());
        session.setAttribute("price", producto.getPrecio());
        session.setAttribute("units", producto.getUnidades());

        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("data", producto);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/editProduct.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getDaoInstance();
        Producto producto = new Producto();
        producto.setNombre(request.getParameter("name"));
        producto.setIdProducto(Integer.parseInt(request.getParameter("id")));
        producto.setPrecio(Double.parseDouble(request.getParameter("price")));
        producto.setUnidades(Integer.parseInt(request.getParameter("units")));
        Boolean result = this.productDao.update(producto);

        PrintWriter out = response.getWriter();

        out.println("<html>");
        if (result) {
            out.println("Producto actualizado con exito");

        } else {
            out.println("<title>No fue posible actualizar</title>");
            out.println("No fue posible actualizar");
        }
        out.println("<a href=\"/crud-mvc\">Ver tabla</a>");
        out.println("</html>");
        out.close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
