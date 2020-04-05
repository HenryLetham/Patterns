package frames;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;


public class CinemaManage {
    private Frame frame;

    public CinemaManage(Frame frame) {
        this.frame = frame;
    }

    public void drawCinema(Parent root) throws IOException {

        HBox imageWrapp = (HBox)root.lookup("#cinemaWrapp");

        for (int i = 0; i < frame.getCntFrames(); i++) {

            Image image = frame.loadFrame(i + 1);

            ImageView temp = new ImageView(image);

            temp.setFitWidth(200);

            imageWrapp.getChildren().add(temp);

        }

    }
}