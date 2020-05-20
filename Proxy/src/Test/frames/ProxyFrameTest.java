package Test.frames;

import Test.mockFiles.BaseFrameMock;
import frames.BaseFrame;
import frames.ProxyFrame;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProxyFrameTest {

    @Test
    public void getCntFrames_baseframe_return5() {

//       arr
        BaseFrameMock baseFrame = new BaseFrameMock();
        ProxyFrame proxyFrame = new ProxyFrame(baseFrame);
        int expected = 5;

        // act
        int res = proxyFrame.getCntFrames();

        // ass

        Assert.assertEquals(expected, res);
    }

}