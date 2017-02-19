package view;

import controller.BookTableController;
import controller.EditDialogController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Book;
import mysql.MysqlOption;
import storage.Storage;

import java.io.IOException;
import java.net.URL;

/**
 * @author ShaliovArtiom.
 */
public class Window extends Application {

    private AnchorPane layout;
    private static Stage primaryStage;

    public Window() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initLayout();
    }


    public void bind() {
        launch();
    }

    private void initLayout() throws Exception {

        MysqlOption.getInstance().readTable();

        URL resource = Window.class.getResource("/table.fxml");
        FXMLLoader loader = new FXMLLoader(resource);
        layout = loader.load();
        Scene scene = new Scene(layout);
        BookTableController controller = loader.getController();
        controller.refresh();
        primaryStage.setTitle("AIPOS2");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static boolean showEditDialog(Book book) throws IOException {
        try {
            URL resource = Window.class.getResource("/dialog.fxml");
            FXMLLoader loader = new FXMLLoader(resource);
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Book");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setBook(book);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

}
