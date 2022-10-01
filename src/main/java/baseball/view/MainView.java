package baseball.view;

import baseball.domain.BaseballNumbers;
import camp.nextstep.edu.missionutils.Console;

public class MainView {
    
    public static BaseballNumbers baseballNumbersForm() {
        return BaseballNumbers.from(Console.readLine());
    }
}
