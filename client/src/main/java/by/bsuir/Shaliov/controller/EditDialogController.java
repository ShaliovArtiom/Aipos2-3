package by.bsuir.Shaliov.controller;

import by.bsuir.Shaliov.service.TransporConnector;
import by.bsuir.Shaliov.service.TransportConnectorService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import by.bsuir.Shaliov.common.model.Book;

/**
 * @author ShaliovArtiom.
 */
public class EditDialogController {

    @FXML
    private TextField bookNameField;

    @FXML
    private TextField bookIdField;

    @FXML
    private TextField authorNameField;

    @FXML
    private TextField pageField;

    private Stage dialogStage;
    private Book book;
    private boolean okClicked = false;

    @FXML
    private void initialize() {}

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setBook(Book book){
        this.book = book;
//        bookIdField.setText(Integer.toString(book.getId()));
        bookNameField.setText(book.getBookName());
        authorNameField.setText(book.getAuthorName());
        pageField.setText(Integer.toString(book.getPageValue()));
    }

    public boolean isOkClicked(){
        return okClicked;
    }

    @FXML
    private void okButton() {
        if (isInputValid()) {
//            book.setId(Integer.parseInt(bookIdField.getText()));
            book.setBookName(bookNameField.getText());
            book.setAuthorName(authorNameField.getText());
            book.setPageValue(Integer.parseInt(pageField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (bookNameField.getText() == null || bookNameField.getText().length() == 0) {
            errorMessage += "No valid Book name!\n";
        }
        if (authorNameField.getText() == null || authorNameField.getText().length() == 0) {
            errorMessage += "No valid Author name!\n";
        }
        if (pageField.getText() == null || pageField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
            try {
                Integer.parseInt(pageField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid page number (must be an integer)!\n";
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void cancelButton() {
        dialogStage.close();
    }
}
