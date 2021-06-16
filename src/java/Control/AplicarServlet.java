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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author german
 */
public class AplicarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   // private CustomerController custCtr = new CustomerController();
        private  Facade Nv = new Facade();
        private String pathFiles = "C:\\Users\\german\\Documents\\NetBeansProjects\\proyectoBeca\\web\\file\\";
	private File uploads = new File(pathFiles);
	private String[] extens = {".rar", ".zip", ".7z", ".rar5"};
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String action = "add";
		
		switch (action) {
		case "add":
			saveCustomer(request, response);
			break;

		default:
			break;
		}
    }
    private void saveCustomer(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			
                        int CodigoBeca = Integer.parseInt(req.getParameter("codigoB"));
                        int CodigoAplicante = Integer.parseInt(req.getParameter("codAplicante"));
			Part part = req.getPart("file");
                        Date ahora = new Date();
                        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
                        String prueba= formateador.format(ahora);
                        Date fechar= formateador.parse(prueba);
                      int codprueba=9999999;
			String estado = "enviada";
			
			if(part == null) {
				System.out.println("No ha seleccionado un archivo");
				return;
			}
			
			if(isExtension(part.getSubmittedFileName(), extens)) {
				String ruta = saveFile(part, uploads);
                                //aqui se agrega los comandos nuestros
                                
				BecaAplicante bec = new BecaAplicante(codprueba,ruta,fechar,estado);
                                bec.setCodbeca(Nv.getBeca(CodigoBeca));
                                bec.setCodaplicante(Nv.getAplicante(CodigoAplicante));
            
                                Nv.RegistrarBecasAplicante(bec);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		res.sendRedirect("/proyectoBeca/jsp/prueba.jsp");
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
