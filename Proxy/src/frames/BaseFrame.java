package frames;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BaseFrame implements Frame {

    public static void setFrames(String[] frames) {
        BaseFrame.frames = frames;
    }

    private static String[] frames = new String[]{};

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
