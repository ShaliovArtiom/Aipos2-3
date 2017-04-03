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

/** Главная таблица
 * @author ShaliovArtiom, TruntsVitalij
 */
public class BookTableController implements Initializable {

    /**
     * Данные, которые заносятся в таблицу
     */
    private ObservableList<Book> data;
    @FXML
    /**
     * Второстепенная таблица
     */
    private TableView<Book> bookTableView;
    @FXML
    /**
     * Столбец названия книги главной таблицы
     */
    private TableColumn<Book, String> bookNameColumn;
    @FXML
    /**
     * Столбец имени автора главной таблицы
     */
    private TableColumn<Book, String> authorNameColumn;
    @FXML

    /**
     * Имя автора во второстепенной таблице
     */
    private Label authorNameLabel;
    @FXML
    /**
     * Название книги во второстепенной таблицы
     */
    private Label bookNameLable;
    @FXML
    /**
     * Количество страниц во второстепенной таблице
     */
    private Label numberOfPageLable;
    @FXML
    /**
     * Id книги во второстепенной таблице
     */
    private Label idLable;

    /**
     * Соединения с MYSQL таблицой
     */
    private TransportConnectorService transportConnectorService;

    /**
     * Функция отображения данных выбранной книги, если они есть
     * @param book книги
     */
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

    /**
     * Функция обработки кнопки New
     * @throws IOException
     * @throws ParseException
     */
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

    /**
     * Функция обработки книпоки Edit
     * @throws IOException
     * @throws ParseException
     */
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

    /**
     * Функция обработки кнопки Delete
     * @throws ParseException
     */
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

    /**
     * Инициализация главной таблицы
     * @param location путь к таблице
     * @param resources данные таблицы
     */
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

    /**
     * Функция обработки кнопки refresh
     * @throws ParseException
     */
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
