/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.persistencia;

import app.modelo.Contacto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tarde
 */
public class AccesoContacto extends Conexion {
    public List<Contacto> obtenerTodos() throws ClassNotFoundException, SQLException{
        //Declarar variables
        String sql = "call obtenertodoslosempleados();";
        CallableStatement comando;
        ResultSet rs;
        List<Contacto> resultado = new ArrayList();
        
        //abrir conexion
        abrirConexion();
        
        //Obtener el comando
        comando = miConexion.prepareCall(sql);
        
        //Ejecutar el comando
        rs = comando.executeQuery();
        
        //Rellenar la coleccion
        while (rs.next()) {
            Contacto e1 = new Contacto(
                    rs.getInt("ID"),
                    rs.getString("NOMBRE"), 
                    rs.getString("EMAIL"),
            		rs.getString("TELEFOMO"));
            resultado.add(e1);
        }
        //Cerrar la conexion
        cerrarConexion();
        //Devolver la coleccion de contactos
        return resultado;
    }
    public Contacto obtenerUno(int idContacto) throws ClassNotFoundException, SQLException{
    //definir variables
    String sql = "call obteneruncontacto(?);";
    CallableStatement comando;
    ResultSet rs;
    Contacto c1=null;
    
    //abrir la conexion
    abrirConexion();
    
    //Obtener el comando de la conexion
    comando = miConexion.prepareCall(sql);
    
    //Asignar valor a los parametros
    comando.setInt(1, idContacto);
    
    //Ejecutar el comando
    rs = comando.executeQuery();
    
    //Instanciar el objeto de la clase Contacto
        if (rs.next()) {
            c1 = new Contacto(
                    idContacto, 
                    rs.getString("NOMBRE"),
                    rs.getString("EMAIL"),
                    rs.getString("TELEFONO"));
        }
        //cerrar conexion
        cerrarConexion();
        //devolver el contacto
        return c1;
    
}
    public boolean insertarContacto(Contacto c1) throws ClassNotFoundException, SQLException{
        //Definir variables
        String sql = "call altaContacto(?, ?);";
        CallableStatement comando;
        int numInsertados=0;
        
        //Abrir la conexion
        abrirConexion();
        
        //Obtener el comando de la conexion
        comando = miConexion.prepareCall(sql);
        
        //Asigno valores a los par�metros
        comando.setString(1, c1.getNombre());
        comando.setString(2, c1.getCorreoElectronico());
        comando.setString(2, c1.getTelefono());
        
        //Ejecutar el comando
        numInsertados = comando.executeUpdate();
        
        //Cerrar conexion
        cerrarConexion();
        
        return numInsertados>=1;
        
    }
    public boolean cambiarContacto(Contacto c1) throws ClassNotFoundException, SQLException{
        //Declaración de variables
        String sql = "call cambiarContacto(?, ?, ?, ?);";
        CallableStatement comando;
        int numModificaciones=0;
        //Abrir conexion
        abrirConexion();
        //Obtener el comando de la conexion
        comando = miConexion.prepareCall(sql);
        //Asignar valor a los parámetros 
        comando.setInt(1, c1.getIdContacto());
        comando.setString(2, c1.getNombre());
        comando.setString(3, c1.getCorreoElectronico());
        comando.setString(4, c1.getTelefono());
        //Ejecutar el comando
        numModificaciones = comando.executeUpdate();
        //Cerrar Conexion
        cerrarConexion();
        return numModificaciones >=1;
        
        
    }
    public boolean eliminarContacto(int idContacto) throws ClassNotFoundException, SQLException{
        //Declarar las variables
        String sql = "call eliminarContacto(?);";
        CallableStatement comando;
        int numEliminados=0;
        
        //Abrir conexion
        abrirConexion();
        
        //Obtener el comando de la conexion
        comando = miConexion.prepareCall(sql);
        
        //Asignar el valor a el parametro
        comando.setInt(1, idContacto);
        
        //Ejecutar el comando
        numEliminados = comando.executeUpdate();
        
        //Cerrar Conexion
        cerrarConexion();
        
        return numEliminados>=1;
    }
}
