package Test.mockFiles;

import frames.Frame;
import javafx.scene.image.Image;

import java.io.IOException;

public class BaseFrameMock implements Frame {
    @Override
    public Image loadFrame(int numFrame) throws IOException {
        return null;
    }

    @Override
    public int getCntFrames() {
        return 5;
    }

}
