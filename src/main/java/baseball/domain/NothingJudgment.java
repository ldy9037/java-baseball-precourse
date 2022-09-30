package baseball.domain;

public class NothingJudgment implements Judgment{
    
    private final int count;

    private NothingJudgment(int count) {
        this.count = count;
    }

    @Override
    public int getCount() {
        return count;
    }

    public static NothingJudgment of(
        BaseballNumberCombination computerCombination, 
        BaseballNumberCombination playerCombination
    ) {
        return new NothingJudgment(judge(computerCombination, playerCombination));
    }

    private static int judge(
        BaseballNumberCombination computerCombination, 
        BaseballNumberCombination playerCombination
    ) { 
        int result = 0;

        for (int i = 0; i < BaseballNumberCombination.NUMBER_SIZE; i++) {
            result += contains(computerCombination.getNumber(i), playerCombination);
        }

        return result;
    }
    
    private static int contains(
        BaseballNumber computerNumber,
        BaseballNumberCombination playerCombination
    ) {
        return (!playerCombination.contains(computerNumber)) ? 1 : 0;
    }
}
