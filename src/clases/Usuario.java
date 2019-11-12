package clases;

import conexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {
    private int id_usuario;
    private String apodo;
    private String clave;
    
    public Usuario() {
        
    }
    
    /**
     * Verifica que las credenciales del usuario con correctas
     * @param usuario String Nombre de usuario
     * @param clave String Clave del usuario
     * @return boolean Validacion de acceso
     */
    public static boolean conectar(String usuario, String clave) {
        boolean valido = false;
        ConexionMySQL sql = new ConexionMySQL();
        // Creamos el String para la consulta a la base de datos
        String query = "SELECT * FROM usuario ";
        query += "WHERE apodo = '" + usuario + "' ";
        query += "AND clave = '" + clave + "';";
        
        try {
            Statement s = sql.conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            
            int filas = 0;
            while(rs.next()){
                filas++;
                // filas = filas + 1;
            }
            if (filas == 1) {
                valido = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valido;
    }
}
