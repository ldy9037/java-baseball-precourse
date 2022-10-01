package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Lists;

public class Game {
    
    private final BaseballNumbers computerNumbers = generateBaseballNumbers();
    private GameStatus gameStatus = GameStatus.IN_PROGRESS;

    public GameStatus getStatus() {
        return gameStatus;
    }

    public Hint getHint(BaseballNumbers playerNumbers) {
        return Hint.of(computerNumbers, playerNumbers);
    }

    private BaseballNumbers generateBaseballNumbers() {
        Set<BaseballNumber> result = new HashSet<>();

        while (!isEnoughSize(result)) {
            result.add(BaseballNumber.newRandomNumber());
        }
        
        return BaseballNumbers.of(Lists.newArrayList(result)); 
    }

    private boolean isEnoughSize(Set<BaseballNumber> baseballNumberList){
        return (baseballNumberList.size() >= BaseballNumbers.NUMBER_SIZE);
    }
}