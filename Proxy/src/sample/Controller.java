package sample;

import frames.CinemaManage;
import frames.ProxyFrame;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;

public class Controller {

    @FXML
    public Button replay;

    @FXML
    public Button clearCache;

    @FXML
    public void clearCache(javafx.event.ActionEvent actionEvent) {
        for (File myFile : new File("src\\cache").listFiles())
            if (myFile.isFile()) myFile.delete();
    }

    @FXML
    public void replay(javafx.event.ActionEvent actionEvent) throws IOException, InterruptedException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        ProxyFrame proxy = new ProxyFrame("src\\cache");
        CinemaManage cinema = new CinemaManage(proxy);

        cinema.drawCinema(root);
    }


}
