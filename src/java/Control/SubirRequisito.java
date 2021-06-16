/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DTO.BecaAplicante;
import FACADE.Facade;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author german
 */
@MultipartConfig
public class SubirRequisito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private static final long serialVersionUID = 1L;
	private Facade Nv = new Facade();
        private String pathFiles = "C:\\Users\\german\\Documents\\NetBeansProjects\\proyectoBeca\\web\\file\\";
	private File uploads = new File(pathFiles);
	private String[] extens = {".rar", ".zip", ".7z", ".rar5"};
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
         int idbeca=Integer.parseInt(request.getParameter("idB"));
         int idaplicante=Integer.parseInt(request.getParameter("idA"));
         String respuesta="nada sirve";
         Date ahora = new Date();
         SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
         String prueba= formateador.format(ahora);
         Date fechar= formateador.parse(prueba);
         int codprueba=123;
	 String estado = request.getParameter("estado");
         
         
        // String action=request.getParameter("action");
         Part part = request.getPart("file");
         if(part == null) {
				respuesta="No ha seleccionado un archivo";
			}
        if(isExtension(part.getSubmittedFileName(), extens)) {
        String ruta = saveFile(part, uploads);
                                //aqui se agrega los comandos nuestros
				BecaAplicante bec = new BecaAplicante(codprueba,ruta,fechar,estado);
                                bec.setCodbeca(Nv.getBeca(idbeca));
                                bec.setCodaplicante(Nv.getAplicante(idaplicante));
            
                                Nv.RegistrarBecasAplicante(bec);
			}
        request.getSession().setAttribute("editar",respuesta);
            request.getRequestDispatcher("Volver?name=1&idUser="+idaplicante+"").forward(request, response); 
        
    }catch (Exception e) {
			e.printStackTrace();
		}
                
    }
    private String saveFile(Part part, File pathUploads) {
		String pathAbsolute = "";
		
		try {
			
			Path path = Paths.get(part.getSubmittedFileName());
			String fileName = path.getFileName().toString();
			InputStream input = part.getInputStream();
			
			if(input != null) {
				File file = new File(pathUploads, fileName);
				pathAbsolute = file.getAbsolutePath();
				Files.copy(input, file.toPath());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pathAbsolute;
	}
    private boolean isExtension(String fileName, String[] extensions) {
		for(String et : extensions) {
			if(fileName.toLowerCase().endsWith(et)) {
				return true;
			}
		}
		
		return false;
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
