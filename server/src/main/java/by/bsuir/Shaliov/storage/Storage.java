package by.bsuir.Shaliov.storage;

import by.bsuir.Shaliov.common.model.Book;
import by.bsuir.Shaliov.mysql.MysqlOption;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Локальная база данных
 * @author ShaliovArtiom, TruntsVitalij
 */
public class Storage {
    /**
     * поле, предназначенное для создания единственного экземпляра класса
     */
    private static Storage instance = null;
    /**
     * Лист книг
     */
    private List<Book> bookList = new ArrayList<>();
    /**
     * Id книги
     */
    private int countId = 0;

    /**
     * Конструктор по умолчанию
     */
    private Storage() {
    }

    /**
     * Добавление книги в лист книг
     * @param book книга, которую необходимо добавить
     */
    public void add(Book book)
    {
        book.setId(countId);
        bookList.add(book);
        countId++;
    }

    /**
     * Функция очистки листа книг
     */
    public void clear() {
        bookList.clear();
    }

    /**
     * Функция поиска книги
     * @param book книга, которую необходимо найти и изменить её поля
     */
    public void findRenameBook(Book book) {
        for (Book findBok : bookList) {
            if (book.getId() == findBok.getId()) {
                findBok.setBookName(book.getBookName());
                findBok.setAuthorName(book.getAuthorName());
                findBok.setPageValue(book.getPageValue());
            }
        }
    }

    /**
     * Функция проверки единственности базы данных
     * @return возвращение значения instance
     */
    public static Storage getIstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    /**
     * Обнуление Id книги
     */
    public void resetCount(){
        countId = 0;
    }

    /**
     * Функция получения листа книг
     * @return возвращает полный лист книг
     */
    public List<Book> getBookList() {
        return bookList;
    }
}
