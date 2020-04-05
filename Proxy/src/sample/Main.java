package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import frames.*;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        ProxyFrame proxy = new ProxyFrame("src\\cache");
        CinemaManage cinema = new CinemaManage(proxy);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Cinema");
        primaryStage.setScene(scene);
        primaryStage.show();

        cinema.drawCinema(root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
