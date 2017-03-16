package by.bsuir.Shaliov.mysql;

import by.bsuir.Shaliov.common.model.Book;
import by.bsuir.Shaliov.common.service.BookService;
import by.bsuir.Shaliov.storage.Storage;
import org.apache.thrift.TException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author ShaliovArtiom.
 */
public class MysqlOption implements BookService.Iface {

    public static MysqlOption instance = null;
    private String query;
    private ResultSet resultSet;
    private DBWorker worker = new DBWorker();


    public MysqlOption() {
        readTable();
    }

    public void readTable() {

        query = "select * from book_table";
        readBookTable();
    }

    private void readBookTable() {
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
            Storage.getIstance().getBookList();
            statement.close();
            worker.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static MysqlOption getInstance() {
        if (instance == null) {
            instance = new MysqlOption();
        }
        return instance;
    }

    @Override
    public void addBookTable(int id, String bookName, String authorName, int pageValue) throws TException {
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "insert into book_table (id, BookName, AuthorName, PageOfBook) values (? ,?, ?, ?);";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, bookName);
            preparedStatement.setString(3, authorName);
            preparedStatement.setInt(4, pageValue);

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        Book book = new Book();
        book.setBookName(bookName);
        book.setId(id);
        book.setAuthorName(authorName);
        book.setPageValue(pageValue);
        worker.closeConnection();
        Storage.getIstance().add(book);
    }

    @Override
    public void renameBookTable(int id, String bookName, String authorName, int pageValue) throws TException {
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = " update book_table SET BookName = ? , AuthorName = ? , PageOfBook =? WHERE id = ?";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, bookName);
            preparedStatement.setString(2, authorName);
            preparedStatement.setInt(3, pageValue);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        worker.closeConnection();
    }

    @Override
    public void deleteBookTable(int id, String bookName, String authorName, int pageValue) throws TException {
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "delete LOW_PRIORITY from book_table WHERE id = ? and BookName = ? and AuthorName = ? and PageOfBook =?;";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, bookName);
            preparedStatement.setString(3, authorName);
            preparedStatement.setInt(4, pageValue);

            preparedStatement.execute();

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        Book book = new Book();
        book.setBookName(bookName);
        book.setId(id);
        book.setAuthorName(authorName);
        book.setPageValue(pageValue);
        worker.closeConnection();
        Storage.getIstance().getBookList().remove(book);
    }

    @Override
    public List<Book> getAllBook() throws TException {
        return null;
    }
}

