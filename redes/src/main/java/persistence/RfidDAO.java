/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import conexion.App;
import conexion.DataBase;
import entity.Persona;
import entity.Rfid;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class RfidDAO {

    private DataBase db;

    public RfidDAO() {
        if (App.DB != null) {
            this.db = App.DB;
        } else {
            throw new RuntimeException("Error: No se ha inicializado la conexión.");
        }
    }

//    public ArrayList<Persona> getAll() {
//        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
//        PreparedStatement psSelectAll = null;
//        ResultSet result = null;
//        try {
//
//            if (psSelectAll == null) {
//                psSelectAll = db.PreparedQuery(
//                        "SELECT cedula, nombre, apellido, celular, correo FROM persona"
//                );
//            }
//            result = db.ExecuteQuery(psSelectAll);
//            while (result.next()) {
//                Persona persona = new Persona();
//                persona.setCedula(result.getString("cedula"));
//                persona.setNombre(result.getString("nombre"));
//                persona.setApellido(result.getString("apellido"));
//                persona.setCelular(result.getInt("celular"));
//                persona.setCorreo(result.getString("correo"));
//
//                listaPersonas.add(persona);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Error al ejecutar consulta.", e);
//        } finally {
//            if (result != null) {
//                try {
//                    result.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException("Error al cerrar el resultset", e);
//                }
//            }
//            if (psSelectAll != null) {
//                try {
//                    psSelectAll.close();
//                    psSelectAll = null;
//                } catch (SQLException e) {
//                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
//                }
//            }
//        }
//        return listaPersonas;
//    }
    public long insert(Rfid rfid) {
        PreparedStatement psInsert = null;
        long result;
        try {
            String columns = "fecha_ent,fecha_sal,Lector_cod_lec,persona_cedula";
            String values = "?,?,?,?";
            if (psInsert == null) {
                psInsert = db.PreparedUpdate(
                        "INSERT INTO rfid(" + columns + ") VALUES(" + values + ")","id_rf"
                );
            }
            ArrayList<Object> inputs = new ArrayList<Object>();

            if (rfid.getFecha_ent() != null) {
                inputs.add(rfid.getFecha_ent());
            } else {
                inputs.add(null);
            }
            if (rfid.getFecha_sal() != null) {
                inputs.add(rfid.getFecha_sal());
            } else {
                inputs.add(null);
            }
            if (rfid.getLector() != null) {
                inputs.add(rfid.getLector().getCod_lec());
            } else {
                inputs.add(null);
            }
            if (rfid.getPersona() != null) {
                inputs.add(rfid.getPersona().getCedula());
            } else {
                inputs.add(null);
            }

            result = db.ExecuteUpdate(psInsert, inputs);
        } catch (SQLException e) {
            throw new RuntimeException("Error al ejecutar inserción.", e);
        } finally {
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Error al cerrar el preparedstatement", e);
                }
            }
        }
        return result;
    }
}
