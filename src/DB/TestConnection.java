package DB;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args)
            throws SQLException {

        Connection conn = DBConnection.getConnection();

        if(conn != null){
            System.out.println("Exitos" + conn.getMetaData().getDatabaseProductVersion());
        }
        else {
            System.out.println("Error al conectarse con la base de datos");
        }
    }
}