package by.bsuir.Shaliov.service;

import by.bsuir.Shaliov.common.model.Book;
import by.bsuir.Shaliov.common.model.BookService;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Класс, реализующий интерфейсы получения данных от сервера
 * @author ShaliovArtiom, TruntsVitalij
 */
public class TransportConnectorService  implements TransportInterface {
    private BookService.Client client;

    /**
     * Конструктор, устанавливающий соединения с сервером
     * @param transportConnector канал связи клиента с сервером
     */
    public TransportConnectorService(TransporConnector transportConnector) {
        client = transportConnector.getClient();
    }
    /**
     * Функция добавления книги в таблицу
     * @param id Id книги
     * @param bookName название книги
     * @param authorName имя автора книги
     * @param pageOfValue количество страниц книги
     */
    @Override
    public void addBook(int id, String bookName, String authorName, int pageOfValue) {
        try {
            client.addBookTable(bookName, authorName, pageOfValue);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    /**
     * Функция изменения книги
     * @param id Id книги
     * @param bookName название книги
     * @param authorName имя автора книги
     * @param pageOfValue количество страниц книги
     */
    @Override
    public void renameBook(int id, String bookName, String authorName, int pageOfValue) {
        try {
            client.renameBookTable(id, bookName, authorName, pageOfValue);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    /**
     * Функция удаления книги
     * @param id Id книги
     * @param bookName название книги
     * @param authorName имя автора книги
     * @param pageOfValue количество страниц книги
     */
    @Override
    public void removeBook(int id, String bookName, String authorName, int pageOfValue) {
        try {
            client.deleteBookTable(id, bookName, authorName, pageOfValue);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получение всех книг из листа
     * @return возвращения листа книг
     */
    @Override
    public List<Book> getAllBook() {
        List<Book> bookList = null;
        try {
           bookList = client.getAllBook();
        } catch (TException e) {
            e.printStackTrace();
        }
        return bookList;
    }

}
