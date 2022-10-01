package baseball.domain;

public class StrikeJudgment implements Judgment{
    
    private final BaseballNumberCombination computerCombination;
    private final BaseballNumberCombination playerCombination;
    
    StrikeJudgment(
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
            result += compare(computerCombination.getNumber(i), playerCombination.getNumber(i));
        }

        return result;
    }
    
    private static int compare(BaseballNumber computerNumber,BaseballNumber playerNumber) {
        return (computerNumber.equals(playerNumber)) ? 1 : 0;
    }
}
