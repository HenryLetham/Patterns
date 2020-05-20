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

        BaseFrame.setFrames(new String[]{
                "https://sun9-53.userapi.com/8DhuS3P3vpdFEOXzaIt1H16g1vcHkZkf0P-Q6A/pXtk9EQ5cGA.jpg",
                "https://sun9-14.userapi.com/13BwmjGq1JDwx3LMabo_yapeYA0YyC44UkKfzA/K1NrQeW7h_8.jpg",
                "https://sun9-37.userapi.com/R2UjiMYatoyMnG2Z0Zl-kGAJk6O3gu3Ys1Jhhg/a5i2wWXNW-8.jpg",
                "https://sun9-48.userapi.com/aj8-EWxNVq8zjz9eaS0Z6pd3FYkMf4UebKAZeQ/tawXFI_K1LY.jpg"
        });

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        ProxyFrame proxy = new ProxyFrame(new BaseFrame());
        CinemaManage cinema = new CinemaManage(proxy);

        Scene scene = new Scene(root, 800, 600);

        cinema.drawCinema(root);

        primaryStage.setTitle("Cinema");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
