package by.bsuir.Shaliov.storage;

import by.bsuir.Shaliov.common.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaliovArtiom.
 */
public class Storage {
    private static Storage istance = null;
    private List<Book> bookList = new ArrayList<>();
    private int countId = 0;
    private Storage() {
    }

    public void add(Book book)
    {
        book.setId(countId);
        bookList.add(book);
        countId++;
    }

    public void clear() {
        bookList.clear();
    }

    public void findRenameBook(Book book) {
        for (Book findBok : bookList) {
            if (book.getId() == findBok.getId()) {
                findBok.setBookName(book.getBookName());
                findBok.setAuthorName(book.getAuthorName());
                findBok.setPageValue(book.getPageValue());
            }
        }
    }

    public static Storage getIstance() {
        if (istance == null) {
            istance = new Storage();
        }
        return istance;
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
