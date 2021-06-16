/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DTO.Becaa;
import FACADE.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author german
 */
public class Aplicar extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         Facade Nv = new Facade();
     /*    String beca=(request.getParameter("name"));
        // Becaa beca= Nv.getBeca(idBeca);
         int id=Integer.parseInt(request.getParameter("name"));
         //request.getSession().setAttribute("user", beca );
         request.getSession().setAttribute("editar", id );
         request.getRequestDispatcher("./jsp/error.jsp").forward(request, response);*/
             /////////////////////////////////////
      int id=Integer.parseInt( request.getParameter("name"));
      String codAplicante=request.getParameter("name2"); 
        Becaa Art= Nv.getBeca(id);
         
           request.getSession().setAttribute("user", Art);
           request.getSession().setAttribute("codAplicante", codAplicante);
           request.getRequestDispatcher("./jsp/ApliarBecas.jsp").forward(request, response);
        }catch(Exception e)        {
        request.getSession().setAttribute("error", e.getMessage());
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
