package order.querycontroller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryController {
    public ResultSet selectNotice(Connection conn, int order_idx) throws SQLException {

        String query = "SELECT order_idx FROM order_r WHERE order_idx = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, order_idx);

        return stmt.executeQuery();
    }
}
