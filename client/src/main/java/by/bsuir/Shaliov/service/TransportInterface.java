package by.bsuir.Shaliov.service;

import by.bsuir.Shaliov.common.model.Book;

import java.util.List;

/**
 * @author ShaliovArtiom.
 */
interface TransportInterface {
    void addBook(int id, String bookName, String authorName, int pageOfValue);

    void renameBook(int id, String bookName, String authorName, int pageOfValue);

    void removeBook(int id, String bookName, String authorName, int pageOfValue);

    List<Book> getAllBook();
}

