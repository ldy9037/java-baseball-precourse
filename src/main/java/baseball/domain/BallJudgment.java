package baseball.domain;

import java.util.List;

public class BallJudgment implements Judgment {
    
    private final int count;
    
    private BallJudgment(int count) {
        this.count = count;
    }

    @Override
    public int getCount() {
        return count;
    }

    public static BallJudgment of(
        BaseballNumberCombination computerCombination, 
        BaseballNumberCombination playerCombination
    ) {
        return new BallJudgment(judge(computerCombination, playerCombination));
    }

    private static int judge(
        BaseballNumberCombination computerCombination, 
        BaseballNumberCombination playerCombination
    ) { 
        int result = 0;

        for (int i = 0; i < BaseballNumberCombination.NUMBER_SIZE; i++) {
            result += findBall(computerCombination.getNumber(i), playerCombination.exceptFor(i));
        }

        return result;
    }
    
    private static int findBall(
        BaseballNumber computerNumber,
        List<BaseballNumber> playerCombination
    ) {
        return (playerCombination.contains(computerNumber)) ? 1 : 0;
    }
}
