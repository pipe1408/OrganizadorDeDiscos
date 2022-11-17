import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Base de Discos");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("img/cd_go.png"));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
