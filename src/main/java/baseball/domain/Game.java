package baseball.domain;

public class Game {
    
    private GameStatus gameStatus = GameStatus.IN_PROGRESS;

    public GameStatus getStatus() {
        return gameStatus;
    }
}
