package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//hacemos unos imports para poder acceder al archivo que tiene las credenciales de la DB
import java.io.FileInputStream;
import java.util.Properties;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        try { //se intenta hacer la conexion usando los datos ocultos
            Properties cred = new Properties();//objeto properties para acceder a los metodos que me permiten entrar al archivo oculto
            cred.load(new FileInputStream("credenciales.properties"));//metodo load para entrar al archivo
            //guardamos las credenciales en las variables
            String URL = cred.getProperty("url");
            String USER = cred.getProperty("usuario");
            String PASS = cred.getProperty("password");

            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch(Exception e) {// muestra error si no logra acceder a los datos
                System.out.println("Error leyendo credenciales");
                return null;
        }
    }
}
