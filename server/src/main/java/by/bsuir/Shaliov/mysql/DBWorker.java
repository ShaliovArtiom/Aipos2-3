package by.bsuir.Shaliov.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ShaliovArtiom.
 */
public class DBWorker {
    private static DBWorker instance = null;
    private final static String PASSWORD = "1234asdqwe";
    private final static String USERNAME = "root";
    private final static String URL = "jdbc:mysql://localhost:3306/aipos";
    private Connection connection;

    public DBWorker() {}

    public void openConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBWorker getInstance() {
        if(instance == null){
            instance = new DBWorker();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

