package repository.connectionUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static ConnectionUtil connectionUtil;

    private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private String DATABASE_URL = "jdbc:mysql://localhost:3306/crud_jdbc?serverTimezone=UTC";
    private String USER = "root";
    private String PASSWORD = "ccWiG9S5GQrp";
    private Connection connection;

    private ConnectionUtil() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static ConnectionUtil getInstance() {
        if(connectionUtil == null) {
            connectionUtil = new ConnectionUtil();
        }
        return connectionUtil;
    }

    public Connection getConnection() {
        return connection;
    }
}
