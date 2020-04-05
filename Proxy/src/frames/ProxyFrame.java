package frames;

import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;

public class ProxyFrame implements Frame {
    private BaseFrame content;
    private String filename;
    private Image Cashe[];
    private int cntFrames = -1;
    private static String cachePath;

    public ProxyFrame(String cachePath) {
        content = new BaseFrame(cachePath);
        this.cachePath = cachePath;
    }

    public int getCntFrames() {
        if(cntFrames != -1)
            return cntFrames;
        else {
            return content.getCntFrames();
        }
    }

    public static void clearCache() {
        for (File myFile : new File(cachePath).listFiles())
            if (myFile.isFile()) myFile.delete();
    }

    public Image loadFrame(int numFrame) throws IOException {

        File frame = new File(cachePath + "\\" + numFrame + ".jpg");

        if(frame.exists()) {
            String localUrl = frame.toURI().toURL().toString();
            System.out.println("Загрузка кадра " + numFrame  + " из кеша");
            return new Image(localUrl);
        } else {
            return content.loadFrame(numFrame);
        }
    }
}
