package frames;

import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;

public class ProxyFrame implements Frame {
    private Frame content;
    private static int cntFrames = -1;


    public ProxyFrame(Frame frame) {
        content = frame;
    }

    public int getCntFrames() {
        if(cntFrames != -1)
            return cntFrames;
        else {
            cntFrames = content.getCntFrames();
            return cntFrames;
        }
    }

    public static void clearCache() {
        for (File myFile : new File("src\\cache").listFiles())
            if (myFile.isFile()) myFile.delete();
        cntFrames = -1;
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
