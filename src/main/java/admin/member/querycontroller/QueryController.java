package admin.member.querycontroller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryController {
    public ResultSet selectMember(Connection conn, int member_idx) throws SQLException {

        String query = "SELECT member_idx FROM member WHERE member_idx = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(0, member_idx);

        return stmt.executeQuery();
    }
}
