/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DTO.Administrador;
import DTO.Aplicante;
import FACADE.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author german
 */
public class ValidarUser extends HttpServlet {

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
            int nom= Integer.parseInt(request.getParameter("txtNombre"));
             int pass=Integer.parseInt( request.getParameter("txtPass"));
             int rol= Integer.parseInt(request.getParameter("rol"));
             int a=1;
             
             if(rol==a){
                 //aplicante
                 Aplicante ap = Nv.getAplicante(nom);
                    
            
                 if(ap!=null){
                     
                    if(ap.getContraseña()==pass){
                     
                  
                   request.getSession().setAttribute("user",ap);
            request.getRequestDispatcher("./jsp/InicioAplicante.jsp").forward(request, response);               
                 }else{
                       request.getSession().setAttribute("editar", "contraseña equivocada");
                      
                  
                 }
                 }else{
                  request.getSession().setAttribute("editar", "usuario no existe");
                   
                 }
                 
             }else{
                  //administrador
              Administrador apli = Nv.getAdmin(nom);
               if(apli!=null){
                    if(apli.getContraseña()==pass){
                            
              request.getSession().setAttribute("user",apli);
            request.getRequestDispatcher("./jsp/InicioAdmin.jsp").forward(request, response);
                    }else{
                    request.getSession().setAttribute("editar", "CONTRASEÑA INVALIDA" );
            request.getRequestDispatcher("./jsp/error.jsp").forward(request, response);
                    }
                  
               }else{
               request.getSession().setAttribute("editar", "ADMINISTRADOR INVALIDO" );
            request.getRequestDispatcher("./jsp/error.jsp").forward(request, response);
               }
             }
           
           
             request.getSession().setAttribute("editar", "FALLAASSSSSSS" );
            request.getRequestDispatcher("./jsp/error.jsp").forward(request, response);
        } catch(Exception e) {
        request.getSession().setAttribute("editar", e);
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
