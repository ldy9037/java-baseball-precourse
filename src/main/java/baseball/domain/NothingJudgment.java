package baseball.domain;

public class NothingJudgment implements Judgment{
    
    private final BaseballNumberCombination computerCombination;
    private final BaseballNumberCombination playerCombination;

    NothingJudgment(
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
            result += contains(computerCombination.getNumber(i), playerCombination);
        }

        return result;
    }
    
    private int contains(
        BaseballNumber computerNumber,
        BaseballNumberCombination playerCombination
    ) {
        return (!playerCombination.contains(computerNumber)) ? 1 : 0;
    }
}
