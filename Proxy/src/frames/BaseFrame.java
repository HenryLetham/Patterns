package frames;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BaseFrame implements Frame {

    private String cachePath;
    BaseFrame(String cachePath) {
        this.cachePath = cachePath;
    }

    private String[] frames = {
            "https://sun9-53.userapi.com/8DhuS3P3vpdFEOXzaIt1H16g1vcHkZkf0P-Q6A/pXtk9EQ5cGA.jpg",
            "https://sun9-14.userapi.com/13BwmjGq1JDwx3LMabo_yapeYA0YyC44UkKfzA/K1NrQeW7h_8.jpg",
            "https://sun9-37.userapi.com/R2UjiMYatoyMnG2Z0Zl-kGAJk6O3gu3Ys1Jhhg/a5i2wWXNW-8.jpg",
            "https://sun9-48.userapi.com/aj8-EWxNVq8zjz9eaS0Z6pd3FYkMf4UebKAZeQ/tawXFI_K1LY.jpg"
    };

    public int getCntFrames() {
        return frames.length;
    }

    public Image loadFrame(int numFrame) throws IOException {

        System.out.println("Загрузка кадра " + numFrame  + " из сети");

        URL url = new URL(frames[numFrame - 1]);
        BufferedImage img = ImageIO.read(url);
        File file = new File(cachePath + "\\" + (numFrame) + ".jpg");

        ImageIO.write(img, "jpg", file);

        return new Image(frames[numFrame - 1]);
    }
}
