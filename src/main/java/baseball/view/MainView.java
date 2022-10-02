package baseball.view;

import baseball.domain.BaseballNumbers;
import baseball.domain.Hint;
import camp.nextstep.edu.missionutils.Console;

public class MainView {
    
    public static BaseballNumbers baseballNumbersForm() {
        return BaseballNumbers.from(Console.readLine());
    }

    public static void printHint(Hint hint) {
        System.out.println(hint.getMessage());
    }
}
