package baseball.domain;

import java.util.List;

public class BaseballNumberCombination {
    
    private final List<BaseballNumber> baseballNumbers;

    BaseballNumberCombination(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public BaseballNumber getNumber(int index) {
        return baseballNumbers.get(index);
    }
}
