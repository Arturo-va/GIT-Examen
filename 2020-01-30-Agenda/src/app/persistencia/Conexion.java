/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tarde
 */
public class Conexion {

    //Atributo
    protected Connection miConexion;

    //Método para abrir la conexion
    public void abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/productos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false",
                "root", "Curso2019$");

    }

    public Connection getMiConexion() {
        return miConexion;
    }

    public void cerrarConexion() throws SQLException {
        miConexion.close();
    }
}
