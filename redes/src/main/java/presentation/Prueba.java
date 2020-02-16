/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import conexion.App;
import entity.Persona;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "Prueba", urlPatterns = {"/Prueba"})
public class Prueba extends HttpServlet {
    
private static final long serialVersionUID = 1L;

    public Prueba() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {// Inicializa conexión con base de datos
            App.OpenConnection();

            boolean sesionValida = true;
            boolean permisoValido = true;
            // Acciones, Envío de parametros y Redirección
            if (sesionValida) {
                if (permisoValido) {
                    request.setCharacterEncoding("UTF-8");
                    request.setAttribute("title", App.nameProyect + " - Prueba");

                    HttpSession session = request.getSession();
                    session.invalidate();
                    
//                    ArrayList<Estrato> listaEstrato = App.EstratoDAO.getAll();
//                    request.setAttribute("listaEstrato", listaEstrato);
                    
                    ArrayList<Persona> personas = App.PersonaDAO.getAll(); // recupero info de la base 
                    for (int i = 0; i < personas.size(); i++) {
                        System.out.println(personas.get(i).getCedula());
                    }
                    request.setAttribute("personas", personas); // envio datos al jsp 
                    getServletConfig().getServletContext().getRequestDispatcher("/views/Prueba.jsp").forward(request, response);
                    
                } else {
                    response.sendRedirect("Error?e=NotAuthorized");
                }
            } else {
                response.sendRedirect("Logout");
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            // Cierra conexión
            App.CloseConnection();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
