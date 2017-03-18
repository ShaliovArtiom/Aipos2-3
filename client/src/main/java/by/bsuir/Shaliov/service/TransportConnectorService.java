package by.bsuir.Shaliov.service;

import by.bsuir.Shaliov.common.model.Book;
import by.bsuir.Shaliov.common.service.BookService;
import org.apache.thrift.TException;

import java.util.List;

/**
 * @author ShaliovArtiom.
 */
public class TransportConnectorService  implements TransportInterface {
    private BookService.Client client;

    public TransportConnectorService(TransporConnector transportConnector) {
        client = transportConnector.getClient();
    }

    @Override
    public void addBook(int id, String bookName, String authorName, int pageOfValue) {
        try {
            client.addBookTable(bookName, authorName, pageOfValue);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void renameBook(int id, String bookName, String authorName, int pageOfValue) {
        try {
            client.renameBookTable(id, bookName, authorName, pageOfValue);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeBook(int id, String bookName, String authorName, int pageOfValue) {
        try {
            client.deleteBookTable(id, bookName, authorName, pageOfValue);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

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
