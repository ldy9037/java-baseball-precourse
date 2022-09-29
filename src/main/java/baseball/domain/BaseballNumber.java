package baseball.domain;

import java.util.Objects;

public class BaseballNumber {
    
    private final int number;

    public BaseballNumber(int number) {
        this.number = number;
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
