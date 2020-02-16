/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Persona;
import entity.Tarjeta;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class TarjetaDAO {

    private DataBase db;

    public TarjetaDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

    public Tarjeta get(String codTarjeta) {
        Tarjeta tarjeta = new Tarjeta();
        ResultSet result = null;
        PreparedStatement psSelect = null;
        try {

            if (psSelect == null) {
                psSelect = db.PreparedQuery(
                        "select codTarjeta, persona_cedula from tarjeta where codTarjeta=?"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();
            inputs.add(codTarjeta);
            result = db.ExecuteQuery(psSelect, inputs);
            while (result.next()) {
                tarjeta.setCodTarjeta(result.getString("codTarjeta"));
                Persona persona = new Persona();
                persona.setCedula(result.getString("persona_cedula"));
                tarjeta.setPersona(persona);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar consulta.", e);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el resultset", e);
                }
            }
            if (psSelect != null) {
                try {
                    psSelect.close();
                    psSelect = null;
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return tarjeta;

    }

    public static void main(String[] args) throws IOException {
        App App = new App();
        try {
            App.OpenConnection();

//											
//			System.out.println("GET ALL");
//			ArrayList<Hijos_Descuentos> listaHijosDescuentos = App.HijosDescuentosDAO.getAll();
//			for (Hijos_Descuentos hijosDescuentos : listaHijosDescuentos){
//				System.out.println(hijosDescuentos.getCodHijosDescuentos()+" "+hijosDescuentos.getPersona().getCodPersona()+" "+hijosDescuentos.getNombre()+" "+hijosDescuentos.getEdad()+" "+hijosDescuentos.getSexo().getCodSexo());
//			}
////			
//			System.out.println("GET ONE");
//			String cod = "e5 0b 5e e2";			
//			Tarjeta tarjeta = App.TarjetaDAO.get(cod);
//			if(tarjeta.getCodTarjeta() != null) {						
//				System.out.println(tarjeta.getPersona().getCedula());
//			}
////			
//			System.out.println("INSERT");
//			Hijos_Descuentos hijosDescuentos = new Hijos_Descuentos();
//			Persona persona = App.PersonaDAO.getPersonaBienestar(100083873);
////			Persona persona = new PersonaDAO().getPersonaBienestar(100083873);
//			System.out.println("cod: "+ persona.getCodPersona());
//			hijosDescuentos.setPersona(persona);
//			hijosDescuentos.setNombre("ANDREA OCHOA");
//			hijosDescuentos.setEdad(22);
//			Sexo sexo = App.SexoDAO.get(1);
//			hijosDescuentos.setSexo(sexo);
//			System.out.println(App.HijosDescuentosDAO.insert(hijosDescuentos));
//			
//			System.out.println("UPDATE");
//			Hijos_Descuentos hijosDescuentos = new Hijos_Descuentos();
//			hijosDescuentos.setCodHijosDescuentos(4);
//			Persona persona = new PersonaDAO().get(100000967);
//			hijosDescuentos.setPersona(persona);
//			hijosDescuentos.setNombre("ANDREA OCHOA MURILLO");
//			hijosDescuentos.setEdad(23);
//			Sexo sexo = new SexoDAO().get(2);
//			hijosDescuentos.setSexo(sexo);
//			System.out.println(App.HijosDescuentosDAO.update(hijosDescuentos));
//			
//			
//			System.out.println("DELETE");
//			App.HijosDescuentosDAO.delete(1);			
//			*/
        } catch (Exception e) {
            throw new RuntimeException("Se ha generado un error inesperado", e);
        } finally {
            App.CloseConnection();
        }
    }
}
