package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumberCombination {
    
    public static final int NUMBER_SIZE = 3;

    private final List<BaseballNumber> baseballNumbers;

    private BaseballNumberCombination(List<BaseballNumber> baseballNumbers) {
        validate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumberCombination of(List<BaseballNumber> baseballNumbers) {
        return new BaseballNumberCombination(baseballNumbers);
    }

    public static BaseballNumberCombination from(String baseNumbers) {
        List<BaseballNumber> baseballNumberList = new ArrayList<>();

        for (char number : baseNumbers.toCharArray()) {
            baseballNumberList.add(new BaseballNumber(Character.getNumericValue(number)));
        }

        return new BaseballNumberCombination(baseballNumberList);
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

    public boolean contains(BaseballNumber baseballNumber) {
        return baseballNumbers.contains(baseballNumber);
    }

    public List<BaseballNumber> exceptFor(int index) {
        List<BaseballNumber> result = new ArrayList<>();
        
        for (BaseballNumber baseballNumber : baseballNumbers) {
            result.add(baseballNumber);
        }

        result.remove(index);
        return result;
    }
}
