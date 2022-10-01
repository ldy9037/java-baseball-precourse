package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class JudgmentFactory {
        
    public static List<Judgment> newJudgments(
        BaseballNumberCombination computerCombination,
        BaseballNumberCombination playerCombination
    ) {
        List<Judgment> result = new ArrayList<>();
        
        result.add(new BallJudgment(computerCombination, playerCombination));
        result.add(new StrikeJudgment(computerCombination, playerCombination));
        result.add(new NothingJudgment(computerCombination, playerCombination));
        
        return result;
    }
}
