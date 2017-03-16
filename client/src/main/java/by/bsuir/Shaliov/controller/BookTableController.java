package by.bsuir.Shaliov.controller;

import by.bsuir.Shaliov.service.TransporConnector;
import by.bsuir.Shaliov.service.TransportConnectorService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import by.bsuir.Shaliov.common.model.Book;
import by.bsuir.Shaliov.view.Window;

import java.io.IOException;
import java.net.URL;
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
    private void newButton() throws IOException {
        Book tempBook = new Book();
        boolean okClicked = Window.showEditDialog(tempBook);
        if (okClicked) {
            TransporConnector.getInstance().openConnection();
            TransportConnectorService transportConnectorService = new TransportConnectorService(TransporConnector.getInstance());
            transportConnectorService.addBook(tempBook.getId(), tempBook.getBookName(), tempBook.getAuthorName(), tempBook.getPageValue());
            TransporConnector.getInstance().closeConnection();

//            MysqlOption.getInstance().addBookTable(tempBook);
            refresh();
        }
    }

    @FXML
    private void editButton() throws IOException {

        Book selectedBook = bookTableView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            boolean okClicked = Window.showEditDialog(selectedBook);
          //  MysqlOption.getInstance().renameBookTable(selectedBook);
            if (okClicked) {
                showDetails(selectedBook);
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
    private void deleteButton() {
        int selectedIndex = bookTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Book book =  bookTableView.getSelectionModel().getSelectedItem();
//            MysqlOption.getInstance().deleteBookTable(book);
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

        refresh();
    }

    public void refresh() {
        TransporConnector.getInstance().openConnection();
        transportConnectorService = new TransportConnectorService(TransporConnector.getInstance());
        data = (ObservableList) transportConnectorService.getAllBook();
        TransporConnector.getInstance().closeConnection();

        // data = Storage.getIstance().getBookList();
        bookTableView.setItems(data);
    }
}
