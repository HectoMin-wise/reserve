package admin.notice.querycontroller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryController {
    public ResultSet selectNotice(Connection conn, int notice_idx) throws SQLException {

        String query = "SELECT notice_idx FROM notice WHERE notice_idx = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(0, notice_idx);

        return stmt.executeQuery();
    }
}
