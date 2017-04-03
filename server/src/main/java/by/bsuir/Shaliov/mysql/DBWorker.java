package by.bsuir.Shaliov.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс, предназначенный для соединения с таблицей MYSQL
 * @author ShaliovArtiom, TruntsVitalij
 */
public class DBWorker {
    /**
     * поле, предназначенное для создания единственного экземпляра класса
     */
    private static DBWorker instance = null;
    /**
     * поле, содержащее пароль к базе данных
     */
    private final static String PASSWORD = "1234asdqwe";
    /**
     * поле, содержащее имя базы данных
     */
    private final static String USERNAME = "root";
    /**
     * поле, содержащее путь к базе данных
     */
    private final static String URL = "jdbc:mysql://localhost:3306/aipos";
    /**
     * поле, предназначенное для соединения с базой данных
     */
    private Connection connection;

    /**
     * конструктор по умолчанию
     */
    public DBWorker() {}

    /**
     * Функция установления соединения с базой данных
     */
    public void openConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Функция закрытия соединения
     */
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Функция проверки единственности базы данных
     * @return возвращение значения instance
     */
    public static DBWorker getInstance() {
        if(instance == null){
            instance = new DBWorker();
        }
        return instance;
    }

    /**
     * Функция получения соединения с базой данных
     * @return возвращает значение connection
     */
    public Connection getConnection() {
        return connection;
    }
}

