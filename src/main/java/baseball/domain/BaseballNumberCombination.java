package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberCombination {
    
    private final List<BaseballNumber> baseballNumbers;

    BaseballNumberCombination(List<BaseballNumber> baseballNumbers) {
        validate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validate(List<BaseballNumber> baseballNumbers) {
        if (isDuplicated(baseballNumbers)) {
            throw new IllegalArgumentException(
                    ErrorMessage.BASEBALL_NUMBER_DUPLICATE_ERROR.getMessage());
        }
    }

    private boolean isDuplicated(List<BaseballNumber> baseballNumbers) {
        Set<BaseballNumber> baseballNumberSet = new HashSet<>(baseballNumbers);
        return (baseballNumbers.size() > baseballNumberSet.size());
    }

    public BaseballNumber getNumber(int index) {
        return baseballNumbers.get(index);
    }
}
