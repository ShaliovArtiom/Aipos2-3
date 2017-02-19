package storage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Book;

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
