package by.bsuir.Shaliov.mysql;

import by.bsuir.Shaliov.common.model.Book;
import by.bsuir.Shaliov.common.model.BookService;
import by.bsuir.Shaliov.storage.Storage;
import org.apache.thrift.TException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Класс, реализующий запросы MYSQL
 * @author ShaliovArtiom, TruntsVitalij
 */
public class MysqlOption implements BookService.Iface {

    /**
     * поле, предназначенное для создания единственного экземпляра класса
     */
    public static MysqlOption instance = null;
    /**
     * поле для ведения лога
     */
    private static final Logger log = Logger.getLogger(MysqlOption.class);
    /**
     * поле для запроса MYSQL
     */
    private String query;
    /**
     * поле содержащее ответ запроса MYSQL
     */
    private ResultSet resultSet;
    /**
     * поле для подключения к таблице в MYSQL
     */
    private DBWorker worker = new DBWorker();

    /**
     * Конструктор, вызывающий функцию readBookTable
     */
    public MysqlOption() {
        readBookTable();
    }

    /**
     * Функция получения полного списка книг из MYSQL
     */
    private void readBookTable() {
        query = "select * from book_table";
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
            log.info("Read table from SQL");
            worker.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("error");
        }
    }

    /**
     * Функция проверки единственности базы данных
     * @return возвращение значения instance
     */
    public static MysqlOption getInstance() {
        if (instance == null) {
            instance = new MysqlOption();
        }
        return instance;
    }

    /**
     * Функция, выполняющая добавление книги в таблицу
     * @param bookName название книги
     * @param authorName имя автора книги
     * @param pageValue количество страниц
     */
    @Override
    public void addBookTable(String bookName, String authorName, int pageValue) {
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        query = "insert into book_table (id, BookName, AuthorName, PageOfBook) values (? ,?, ?, ?);";
        Book book = new Book();
        book.setBookName(bookName);
        book.setAuthorName(authorName);
        book.setPageValue(pageValue);
        Storage.getIstance().add(book);
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, bookName);
            preparedStatement.setString(3, authorName);
            preparedStatement.setInt(4, pageValue);

            preparedStatement.execute();
            log.info("Add book in table");

        } catch (SQLException e1) {
            e1.printStackTrace();
            log.error("error");
        }
        worker.closeConnection();
    }

    /**
     * Функция, выполняющая изменение данных книги
     * @param id Id книги
     * @param bookName название книги
     * @param authorName имя автора книги
     * @param pageValue количество страниц книги
     */
    @Override
    public void renameBookTable(int id, String bookName, String authorName, int pageValue) {
        DBWorker worker = DBWorker.getInstance();
        PreparedStatement preparedStatement = null;
        Book findBook = new Book();
        findBook.setBookName(bookName);
        findBook.setId(id);
        findBook.setAuthorName(authorName);
        findBook.setPageValue(pageValue);
        Storage.getIstance().findRenameBook(findBook);

        query = " update book_table SET BookName = ? , AuthorName = ? , PageOfBook =? WHERE id = ?";
        try {
            worker.openConnection();
            preparedStatement = worker.getConnection().prepareStatement(query);
            preparedStatement.setString(1, bookName);
            preparedStatement.setString(2, authorName);
            preparedStatement.setInt(3, pageValue);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
            log.info("Chanched the book");

        } catch (SQLException e1) {
            e1.printStackTrace();
            log.error("error");
        }
        worker.closeConnection();
    }

    /**
     * Функция, выполняющая удаление книги
     * @param id Id книги
     * @param bookName название книги
     * @param authorName имя автора книги
     * @param pageValue количество страниц книги
     */
    @Override
    public void deleteBookTable(int id, String bookName, String authorName, int pageValue) {
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
            log.info("Remove the book");

        } catch (SQLException e1) {
            e1.printStackTrace();
            log.error("error");
        }

        Book book = new Book();
        book.setBookName(bookName);
        book.setId(id);
        book.setAuthorName(authorName);
        book.setPageValue(pageValue);
        worker.closeConnection();
        Storage.getIstance().getBookList().remove(book);

    }

    /**
     * Функция получения всех книги из таблицы MYSQL
     * @return возвращает лист книг
     */
    @Override
    public List<Book> getAllBook() {
        Storage.getIstance().getBookList().clear();
        Storage.getIstance().resetCount();
        readBookTable();
        log.info("Get list book");
        return Storage.getIstance().getBookList();
    }

}

