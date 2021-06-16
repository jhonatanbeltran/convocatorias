/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DTO.Aplicante;
import FACADE.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author german
 */
public class NuevoAplicante2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try  {
            /* TODO output your page here. You may use following sample code. */
                  
            Facade Nv = new Facade();
           int ced=Integer.parseInt( request.getParameter("cedula"));
           int pass=Integer.parseInt( request.getParameter("pass"));
           String Pnombre= request.getParameter("primerN");
           String Snombre=request.getParameter("segundoN");
           String Papellido= request.getParameter("primerA");
           String Sapellido=request.getParameter("segundA");
           String recibefecha = request.getParameter("fecha");
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           Date fecha= sdf.parse(recibefecha);
           String correo= request.getParameter("email");
           String cel=request.getParameter("celular");
           
           
           
           Aplicante Apl = new Aplicante(ced,pass,Pnombre,Snombre,Papellido,Sapellido,fecha,correo,cel);
           Nv.InsertarAplicante(Apl);
           
           request.getRequestDispatcher("./index.html").forward(request, response);
        }catch(Exception e)
        {   
           
        request.getSession().setAttribute("editar", e.getMessage());
            request.getRequestDispatcher("./jsp/error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
