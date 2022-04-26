package db;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class MariaJdbc implements DBConnection {
    private Logger logger = LoggerFactory.getLogger(MariaJdbc.class);

    @Override
    public Connection getConnection() {
        final String SERVER_IP = "hectodb.cpwxmhj0mhhh.ap-northeast-2.rds.amazonaws.com";
        final String PORT = "3306";
        final String NAME = "hectodb";
        final String ID = "admin";
        final String PASSWORD = "admin1234";

        Connection conn = null;
        
        try {
            logger.info("DB Connect Start");

            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://"+SERVER_IP+":"+PORT+"/"+NAME;

            conn = DriverManager.getConnection(url, ID, PASSWORD);

            logger.info("DB Connect Success");
            logger.info("DB Connect Info -> {}",url);


        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
