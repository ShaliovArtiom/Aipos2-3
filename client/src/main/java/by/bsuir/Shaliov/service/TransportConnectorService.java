package by.bsuir.Shaliov.service;

import by.bsuir.Shaliov.common.model.Book;
import by.bsuir.Shaliov.common.service.BookService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.thrift.TException;

import java.util.ArrayList;
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
            client.addBookTable(id, bookName, authorName, pageOfValue);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void renameBook(int id, String bookName, String authorName, int pageOfValue) {

    }

    @Override
    public void removeBook(int id, String bookName, String authorName, int pageOfValue) {

    }

    @Override
    public List<Book> getAllBook() {
        return null;
    }

}
