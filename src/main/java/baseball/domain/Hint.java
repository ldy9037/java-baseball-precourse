package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Hint {
    
    private final List<Judgment> judgments;

    private Hint(List<Judgment> judgments) {
        this.judgments = judgments;
    }

    public static Hint of(BaseballNumbers computerNumbers, BaseballNumbers playerNumbers) {
        List<Judgment> judgments = JudgmentFactory.newJudgments(computerNumbers, playerNumbers);
        return new Hint(judgments);
    }

    public String getMessage() {
        List<String> resultList = convertResultList();
        return String.join(" ", resultList).trim();
    }

    private List<String> convertResultList() {
        List<String> result = new ArrayList<>();
        
        for (Judgment judgment : judgments) {
            result.add(judgment.getResult());
        }

        return result;
    }
}
