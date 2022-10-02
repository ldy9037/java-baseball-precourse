package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.Game;
import baseball.domain.GameStatus;
import baseball.domain.Hint;
import baseball.view.MainView;

public class MainController {
    
    private Game game = null;

    public void start() {
        startValidate();

        game = new Game();

        requestBaseballNumbersForm();
    }

    private void requestBaseballNumbersForm() {
        MainView.baseballNumbersForm(this);
    }

    public void requestHint(BaseballNumbers playerNumbers) {
        Hint model = game.getHint(playerNumbers);
        MainView.printHint(model);
        
        if (isInProgress()) {
            requestBaseballNumbersForm();
        }
    }

    private void startValidate() {
        if (isInProgress()) {
            throw new IllegalAccessError(
                    ErrorMessage.GAME_ALREADY_IN_PROGRESS_ERROR.getMessage());
        }
    }

    private boolean isInProgress() {
        return (!isNull() && game.getStatus() == GameStatus.IN_PROGRESS);
    }

    private boolean isNull() {
        return (game == null);
    }   
}
