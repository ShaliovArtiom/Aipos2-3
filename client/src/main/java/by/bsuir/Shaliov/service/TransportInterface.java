package by.bsuir.Shaliov.service;

import by.bsuir.Shaliov.common.model.Book;

import java.util.List;

/**
 * Интерфейс получения данных от сервера
 * @author ShaliovArtiom, TruntsVitalij
 */
interface TransportInterface {
    /**
     * Интерфейс добавления книги в таблицу
     * @param id Id книги
     * @param bookName название книги
     * @param authorName имя автора книги
     * @param pageOfValue количество страниц книги
     */
    void addBook(int id, String bookName, String authorName, int pageOfValue);

    /**
     * Интерфейс изменения книги
     * @param id Id книги
     * @param bookName название книги
     * @param authorName имя автора книги
     * @param pageOfValue количество страниц книги
     */
    void renameBook(int id, String bookName, String authorName, int pageOfValue);

    /**
     * Интерфейс удаления книги
     * @param id Id книги
     * @param bookName название книги
     * @param authorName имя автора книги
     * @param pageOfValue количество страниц книги
     */
    void removeBook(int id, String bookName, String authorName, int pageOfValue);

    /**
     * Получение всех книг из листа
     * @return возвращения листа книг
     */
    List<Book> getAllBook();
}

