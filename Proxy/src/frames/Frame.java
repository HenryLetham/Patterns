package frames;

import javafx.scene.image.Image;

import java.io.IOException;

public interface Frame {
     Image loadFrame(int numFrame) throws IOException;
     int getCntFrames();

     String cachePath = "src\\cache";
}

