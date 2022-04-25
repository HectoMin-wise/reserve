package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ojdbc implements DBConnection {

    @Override
    public Connection getConnection() {
        final String SERVER_IP = "13.52.44.60";
        final String PORT = "1521";
        final String NAME = "xe";
        final String ID = "hecto";
        final String PASSWORD = "hecto";

        Connection conn = null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@"+SERVER_IP+":"+PORT+":"+NAME;

            conn = DriverManager.getConnection(url, ID, PASSWORD);

        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
