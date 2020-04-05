package sample;

import checkResult.LoseCheckMiddleware;
import checkResult.Middleware;
import checkResult.ReplayCheckMiddleware;
import checkResult.WinCheckMiddleware;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;



public class Controller {

    private static int winPrizeNum;
    public static int cash = 6;
    private Middleware middleware;
    private boolean is_win;

    @FXML
    private ToggleGroup coins;

    @FXML
    private Button startButton;

    @FXML
    private Label balance;

    @FXML
    private FlowPane coinWrapp;


    private ToggleButton currentToggle;

    @FXML
    public void initialize() {
        updateBalance();

        Middleware win = new WinCheckMiddleware();
        Middleware lose =  new LoseCheckMiddleware();
        Middleware replay = new ReplayCheckMiddleware();

        lose.linkWith(replay);
        win.linkWith(lose);

        this.setMiddleware(
                win
        );
    }


    @FXML
    public void startGame() {
        this.cash--;

        Controller.hidePrize(3);

        updateBalance();

        coinWrapp.setDisable(false);
        startButton.setDisable(true);

    }

    @FXML
    public void showRules ()  throws Exception {
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("/rules/rules.fxml"));
        stage.setTitle("Правила игры");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void chooseBag() {
        coinWrapp.setDisable(true);
        currentToggle = (ToggleButton)coins.getSelectedToggle();

        currentToggle.setSelected(false);

        int chooseBag = Integer.parseInt((String)currentToggle.getUserData());

        is_win = (chooseBag == winPrizeNum) ? true : false;

        boolean replay = middleware.check(is_win);

        updateBalance();

        if(replay) {
            coinWrapp.setDisable(false);
        } else {
            startButton.setDisable(false);
            coinWrapp.setDisable(true);
        }
    }

    public static void hidePrize(int countBags) {
        winPrizeNum = 1 + (int)(Math.random() * countBags);
    }

    public void updateBalance() {
        balance.setText("Баланс: " + cash);
    }

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }
}
