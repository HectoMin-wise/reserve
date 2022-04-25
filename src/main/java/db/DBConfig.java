package db;

public class DBConfig {
    private static DBConnection dbConnection;

    private DBConfig() {}

    public static DBConnection getDbInstance() {
        if (dbConnection == null) {
            dbConnection = new Ojdbc();
        }
        return dbConnection;
    }
}
