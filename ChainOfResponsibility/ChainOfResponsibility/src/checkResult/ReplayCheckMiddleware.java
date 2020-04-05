package checkResult;

import sample.Controller;

public class ReplayCheckMiddleware extends Middleware {

    public boolean check(boolean result) {

        Controller.cash -= 1;
        Controller.hidePrize(3);

        return true;
    }
}
