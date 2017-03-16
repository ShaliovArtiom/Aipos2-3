package by.bsuir.Shaliov.storage;

import by.bsuir.Shaliov.common.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author ShaliovArtiom.
 */
public class Storage {
    private static Storage istance = null;
    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    private Storage(){}

    public void add(Book book) {bookList.add(book);}
    public void clear () {bookList.clear();}

    public static Storage getIstance(){
        if(istance == null) {
            istance = new Storage();
        }
        return istance;
    }

    public ObservableList getBookList(){
        return bookList;
    }
}