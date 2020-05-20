package sample;

import frames.BaseFrame;
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
       ProxyFrame.clearCache();
    }

    @FXML
    public void replay(javafx.event.ActionEvent actionEvent) throws IOException, InterruptedException {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        ProxyFrame proxy = new ProxyFrame(new BaseFrame());
        CinemaManage cinema = new CinemaManage(proxy);

        cinema.drawCinema(root);

//        return root;
    }
}
