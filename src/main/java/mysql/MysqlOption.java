package mysql;

import model.Book;
import storage.Storage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ShaliovArtiom.
 */
public class MysqlOption {

    public static MysqlOption instance = null;
    private String query;
    private ResultSet resultSet;
    private DBWorker worker = DBWorker.getInstance();


    public MysqlOption() {
    }

    public void readTable() {

        query = "select * from book_table";
        readPriceTableSQL();
    }

    private void readPriceTableSQL() {
        try {
            worker.openConnection();
            Statement statement = worker.getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt(1));
                book.setBookName(resultSet.getString(2));
                book.setAuthorName(resultSet.getString(3));
                book.setPageValue(resultSet.getInt(4));
                Storage.getIstance().add(book);
            }
            statement.close();
            worker.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBookTable(Book book){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "insert into book_table (id, BookName, AuthorName, PageOfBook) values (? ,?, ?, ?);";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setString(3, book.getAuthorName());
            preparedStatement.setInt(4, book.getPageValue());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
        Storage.getIstance().add(book);
    }

    public void deleteBookTable(Book book){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "delete LOW_PRIORITY from book_table WHERE id = ? and BookName = ? and AuthorName = ? and PageOfBook =?;";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setString(3, book.getAuthorName());
            preparedStatement.setInt(4, book.getPageValue());

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
        Storage.getIstance().getBookList().remove(book);
    }

    public void renameBookTable(Book book){
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = " update book_table SET BookName = ? , AuthorName = ? , PageOfBook =? WHERE id = ?";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getAuthorName());
            preparedStatement.setInt(3, book.getPageValue());
            preparedStatement.setInt(4, book.getId());
            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
    }



    public static MysqlOption getInstance() {
        if (instance == null) {
            instance = new MysqlOption();
        }
        return instance;
    }
}

