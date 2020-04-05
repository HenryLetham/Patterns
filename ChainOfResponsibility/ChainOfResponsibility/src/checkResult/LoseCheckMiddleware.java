package checkResult;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import sample.Controller;

import java.util.Optional;

public class LoseCheckMiddleware extends Middleware {
    public boolean check(boolean result) {
        if(result)
            return checkNext(result);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Вы проиграли!");
        alert.setHeaderText("Монетка потеряна, но всегда можно отыграться!");

        ButtonType replay = new ButtonType("Продолжить играть", ButtonBar.ButtonData.YES);
        ButtonType vacation = new ButtonType("Отдохнуть", ButtonBar.ButtonData.NO);

        alert.getButtonTypes().clear();

        alert.getButtonTypes().addAll(replay, vacation);

        Optional<ButtonType> option = alert.showAndWait();

        if(option.get().getButtonData() == ButtonBar.ButtonData.YES)
            return this.checkNext(result);
        else
            return false;

    }
}
