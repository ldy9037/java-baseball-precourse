package baseball.controller;

public enum ErrorMessage {

    GAME_ALREADY_IN_PROGRESS_ERROR("이미 게임이 진행중입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    } 

    public String getMessage() {
        return message;
    }

    public String getMessage(Object... values) {
        return String.format(message, values);
    }
}
