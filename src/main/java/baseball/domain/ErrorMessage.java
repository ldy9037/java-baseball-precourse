package baseball.domain;

public enum ErrorMessage {

    BASEBALL_NUMBER_OUT_OF_RANGE_ERROR("야구 숫자는 %d ~ %d 범위만 지정 가능합니다.");

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
