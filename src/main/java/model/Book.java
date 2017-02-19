package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author ShaliovArtiom.
 */
public class Book {

    private final IntegerProperty id;
    private final StringProperty bookName;
    private final StringProperty authorName;
    private final IntegerProperty pageValue;

    public Book(){
        this(null, null);
    }

    public Book(String nameBook, String nameAuthor) {
        id = new SimpleIntegerProperty(0);
        pageValue = new SimpleIntegerProperty(0);
        authorName = new SimpleStringProperty(nameAuthor);
        bookName = new SimpleStringProperty(nameBook);
    }


    public void setBookName(String name) {
        bookName.setValue(name);
    }

    public String getBookName() {
        return bookName.get();
    }

    public StringProperty getBookNameProperty() {
        return bookName;
    }

    public void setAuthorName(String name) {
        authorName.set(name);
    }

    public String getAuthorName() {
        return authorName.get();
    }

    public StringProperty getAuthorNameProperty() {
        return authorName;
    }

    public void setPageValue(int value) {
        pageValue.set(value);
    }

    public int getPageValue() {return pageValue.get();}

    public IntegerProperty getPageValueProperty() {
        return pageValue;
    }

    public void setId(int value) {id.set(value);}

    public int getId() {return id.get();}

    public IntegerProperty getIdProperty() {
        return id;
    }

}
