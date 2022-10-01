package baseball.domain;

import java.util.List;

public class BallJudgment implements Judgment {
    
    private final BaseballNumberCombination computerCombination;
    private final BaseballNumberCombination playerCombination;
    
    BallJudgment(
        BaseballNumberCombination computerCombination, 
        BaseballNumberCombination playerCombination
    ) {
        this.computerCombination = computerCombination;
        this.playerCombination = playerCombination;
    }

    @Override
    public int getCount() {
        return judge();
    }

    private int judge() { 
        int result = 0;

        for (int i = 0; i < BaseballNumberCombination.NUMBER_SIZE; i++) {
            result += findBall(computerCombination.getNumber(i), playerCombination.exceptFor(i));
        }

        return result;
    }
    
    private int findBall(BaseballNumber computerNumber, List<BaseballNumber> playerCombination) {
        return (playerCombination.contains(computerNumber)) ? 1 : 0;
    }
}
