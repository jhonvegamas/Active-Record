package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jhon Vega <jhonvegamas@gmail.com>
 */
public class ConnectionMySQL {

    /**
     * Parametros de conexion
     */
    private Connection connection = null;
    private String name = "db_pattern";
    private String login = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost/";
    private String dsn = url + name;

    /**
     * Constructor de DbConnection
     */
    public ConnectionMySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(dsn, login, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Permite retornar la conexión
     */
    public Connection getConnection() {
        return this.connection;
    }
}
