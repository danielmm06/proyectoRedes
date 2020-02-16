/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
import conexion.App;
import entity.Lector;
import entity.Rfid;
import entity.Tarjeta;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "capturarDatos", urlPatterns = {"/capturarDatos"})
public class capturarDatos extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public capturarDatos() {
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

                    String lector = request.getParameter("lector");
                    String codigo = request.getParameter("cod");
//                  
                    request.setAttribute("lector", lector); // envio datos al jsp 
                    request.setAttribute("codigo", codigo); // envio datos al jsp 

                    getServletConfig().getServletContext().getRequestDispatcher("/views/CapturarDatos.jsp").forward(request, response);

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
        try {// Inicializa conexión con base de datos
            App.OpenConnection();
            
            Rfid rfid = new Rfid();
            
            Calendar fecha = new GregorianCalendar();
            int año = fecha.get(Calendar.YEAR);
            int mes = fecha.get(Calendar.MONTH);
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int hora = fecha.get(Calendar.HOUR_OF_DAY);
            int minuto = fecha.get(Calendar.MINUTE);
            int segundo = fecha.get(Calendar.SECOND);
            
            System.out.println("Fecha Actual: " + año + "-" + (mes + 1) + "-" + dia + " " + hora + ":" + minuto + ":" + segundo);

            String parametro1 = request.getParameter("lector");
            Lector lector = new Lector();
            lector.setCod_lec(parametro1);
            String parametro2 = request.getParameter("codTerjeta");
            Tarjeta tarjeta = App.TarjetaDAO.get(parametro2);
            
            System.out.println("POST   ----->>>> " + parametro1 + " " + parametro2);
            System.out.println("tarjeta  ----->>>> " + tarjeta.getPersona().getCedula());
            
            if ((!parametro1.equals("")) && (!parametro2.equals("")) ) {
                System.out.println("Entro------ ");
                rfid.setFecha_ent(año + "-" + (mes + 1) + "-" + dia + " " + hora + ":" + minuto + ":" + segundo);
                rfid.setFecha_sal(año + "-" + (mes + 1) + "-" + dia + " " + hora + ":" + minuto + ":" + segundo);
                rfid.setLector(lector);
                rfid.setPersona(tarjeta.getPersona());
                App.RfidDAO.insert(rfid);
                System.out.println("inserto......................");
                response.getWriter().print(true);
            } else {
                response.getWriter().print(false);
            }
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            // Cierra conexión
            App.CloseConnection();
        }
    }

}
