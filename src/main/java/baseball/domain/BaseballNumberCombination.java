package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberCombination {
    
    public static final int NUMBER_SIZE = 3;

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

        if (isWorngSize(baseballNumbers)) {
            throw new IllegalArgumentException(
                    ErrorMessage.BASEBALL_NUMBER_WORNG_SIZE_ERROR.getMessage(NUMBER_SIZE));
        }
    }

    private boolean isDuplicated(List<BaseballNumber> baseballNumbers) {
        Set<BaseballNumber> baseballNumberSet = new HashSet<>(baseballNumbers);
        return (baseballNumbers.size() > baseballNumberSet.size());
    }

    private boolean isWorngSize(List<BaseballNumber> baseballNumbers) {
        return (baseballNumbers.size() != NUMBER_SIZE);
    }

    public BaseballNumber getNumber(int index) {
        return baseballNumbers.get(index);
    }
}
