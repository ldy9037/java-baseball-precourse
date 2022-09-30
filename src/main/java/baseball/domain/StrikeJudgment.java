package baseball.domain;

public class StrikeJudgment implements Judgment{
    
    private final int count;
    
    private StrikeJudgment(int count) {
        this.count = count;
    }

    @Override
    public int getCount() {
        return count;
    }

    public static StrikeJudgment of(
        BaseballNumberCombination computerCombination, 
        BaseballNumberCombination playerCombination
    ) {
        return new StrikeJudgment(judge(computerCombination, playerCombination));
    }

    private static int judge(
        BaseballNumberCombination computerCombination, 
        BaseballNumberCombination playerCombination
    ) { 
        int result = 0;

        for (int i = 0; i < BaseballNumberCombination.NUMBER_SIZE; i++) {
            result += compare(computerCombination.getNumber(i), playerCombination.getNumber(i));
        }

        return result;
    }
    
    private static int compare(
        BaseballNumber computerNumber,
        BaseballNumber playerNumber
    ) {
        return (computerNumber.equals(playerNumber)) ? 1 : 0;
    }
}
