package baseball.controller;

import baseball.domain.Game;

public class MainController {
    
    private Game game;

    public void start() {
        this.game = new Game();
        getBaseballNumbersInput();
    }

    private void getBaseballNumbersInput() {
    }
}
