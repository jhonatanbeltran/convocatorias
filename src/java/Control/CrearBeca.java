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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author german
 */
public class CrearBeca extends HttpServlet {

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
            
            Facade Nv = new Facade();

             int codB=Integer.parseInt( request.getParameter("codigoB"));
           String nombreB= request.getParameter("beca_nombre");
           String descripcion=request.getParameter("descripcion");
           String rubro= request.getParameter("Rubro");
           String fechaI = request.getParameter("fechaI");
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           Date fechai= sdf.parse(fechaI);
           String fechaF = request.getParameter("fechaC");
           SimpleDateFormat conver = new SimpleDateFormat("yyyy-MM-dd");
           Date fechaf= conver.parse(fechaF);
           Date ahora = new Date();
            SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
            String prueba= formateador.format(ahora);
            Date fechar= formateador.parse(prueba);
            String requisitos = request.getParameter("requisitos");
            String estado= "Abierta";
            
            Becaa bec = new Becaa(codB,nombreB,descripcion,requisitos,estado,rubro,fechai,fechaf,fechar);
            Nv.InsertarBeca(bec);
             request.getRequestDispatcher("./jsp/InicioAdmin.jsp").forward(request, response);
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
