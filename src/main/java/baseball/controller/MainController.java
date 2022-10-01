package baseball.controller;

import baseball.domain.Game;
import baseball.domain.GameStatus;

public class MainController {
    
    private Game game = null;

    public void start() {
        startValidate();

        game = new Game();

        getBaseballNumbersInput();
    }

    private void getBaseballNumbersInput() {
    }

    private void startValidate() {
        if (isInProgress()) {
            throw new IllegalAccessError(
                    ErrorMessage.GAME_ALREADY_IN_PROGRESS_ERROR.getMessage());
        }
    }

    private boolean isInProgress() {
        return (game != null && game.getStatus() == GameStatus.IN_PROGRESS);
    }
}
