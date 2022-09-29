package baseball.domain;

import java.util.Objects;

public class BaseballNumber {
    
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIUM_NUMBER = 9;

    private final int number;

    public BaseballNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException(
                    ErrorMessage.BASEBALL_NUMBER_OUT_OF_RANGE_ERROR.getMessage(MINIMUM_NUMBER, MAXIUM_NUMBER));
        }
    }

    private boolean isValid(int number) {
        return (number >= MINIMUM_NUMBER && number <= MAXIUM_NUMBER);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BaseballNumber)) {
            return false;
        }

        BaseballNumber that = (BaseballNumber) obj;
        return (this.number == that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
