package by.bsuir.Shaliov.controller;

import by.bsuir.Shaliov.service.TransporConnector;
import by.bsuir.Shaliov.service.TransportConnectorService;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import by.bsuir.Shaliov.common.model.Book;
import by.bsuir.Shaliov.view.Window;
import javafx.util.Callback;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author ShaliovArtiom.
 */
public class BookTableController implements Initializable {


    private ObservableList<Book> data;
    @FXML
    private TableView<Book> bookTableView;
    @FXML
    private TableColumn<Book, String> bookNameColumn;
    @FXML
    private TableColumn<Book, String> authorNameColumn;
    @FXML

    private Label authorNameLabel;
    @FXML
    private Label bookNameLable;
    @FXML
    private Label numberOfPageLable;
    @FXML
    private Label idLable;

    private TransportConnectorService transportConnectorService;


    public void showDetails(Book book) {

        if (book != null) {
            bookNameLable.setText(book.getBookName());
            authorNameLabel.setText(book.getAuthorName());
            numberOfPageLable.setText(String.valueOf(book.getPageValue()));
            idLable.setText(String.valueOf(book.getId()));
        } else {
            bookNameLable.setText("");
            authorNameLabel.setText("");
            numberOfPageLable.setText("");
            idLable.setText("");
        }
    }

    @FXML
    private void newButton() throws IOException, ParseException {
        Book tempBook = new Book();
        boolean okClicked = Window.showEditDialog(tempBook);
        if (okClicked) {
            TransporConnector.getInstance().openConnection();
            TransportConnectorService transportConnectorService = new TransportConnectorService(TransporConnector.getInstance());
            transportConnectorService.addBook(tempBook.getId(), tempBook.getBookName(), tempBook.getAuthorName(), tempBook.getPageValue());
            TransporConnector.getInstance().closeConnection();
            refresh();
        }
    }

    @FXML
    private void editButton() throws IOException, ParseException {

        Book selectedBook = bookTableView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            boolean okClicked = Window.showEditDialog(selectedBook);
            if (okClicked) {
                TransporConnector.getInstance().openConnection();
                TransportConnectorService transportConnectorService = new TransportConnectorService(TransporConnector.getInstance());
                transportConnectorService.renameBook(selectedBook.getId(), selectedBook.getBookName(), selectedBook.getAuthorName(), selectedBook.getPageValue());
                TransporConnector.getInstance().closeConnection();

                showDetails(selectedBook);
                refresh();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Window.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }

    }

    @FXML
    private void deleteButton() throws ParseException {
        int selectedIndex = bookTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Book book =  bookTableView.getSelectionModel().getSelectedItem();
            TransporConnector.getInstance().openConnection();
            TransportConnectorService transportConnectorService = new TransportConnectorService(TransporConnector.getInstance());
            transportConnectorService.removeBook(book.getId(), book.getBookName(), book.getAuthorName(), book.getPageValue());
            TransporConnector.getInstance().closeConnection();

            data.remove(book);
            refresh();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Window.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Book Selected");
            alert.setContentText("Please select a book in the table.");

            alert.showAndWait();
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        bookNameColumn.setCellValueFactory(cellData -> cellData.getValue().getBookNameProperty());
        authorNameColumn.setCellValueFactory(cellData -> cellData.getValue().getAuthorNameProperty());

        showDetails(null);

        bookTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetails(newValue));

        try {
            refresh();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void refresh() throws ParseException {
        TransporConnector.getInstance().openConnection();
        transportConnectorService = new TransportConnectorService(TransporConnector.getInstance());
        List<Book> bookList = transportConnectorService.getAllBook();
        TransporConnector.getInstance().closeConnection();
        data = null;
        data = FXCollections.observableArrayList();
        for (Book book : bookList) {
            data.add(book);
        }
        bookTableView.setItems(data);
    }
}
