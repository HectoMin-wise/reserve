package db;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Ojdbc implements DBConnection {
    private Logger logger = LoggerFactory.getLogger(Ojdbc.class);

    @Override
    public Connection getConnection() {
        final String SERVER_IP = "13.52.44.60";
        final String PORT = "1521";
        final String NAME = "xe";
        final String ID = "hecto";
        final String PASSWORD = "hecto";

        Connection conn = null;
        
        try {
            logger.info("DB Connect Start");

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@"+SERVER_IP+":"+PORT+":"+NAME;

            conn = DriverManager.getConnection(url, ID, PASSWORD);

            logger.info("DB Connect Success");
            logger.info("DB Connect Info : {}",url);


        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
