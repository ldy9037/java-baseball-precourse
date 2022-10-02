package baseball.view;

import baseball.controller.MainController;
import baseball.domain.BaseballNumbers;
import baseball.domain.Hint;
import camp.nextstep.edu.missionutils.Console;

public class MainView {
    
    public static void baseballNumbersForm(MainController mainController) {
        BaseballNumbers baseballNumbers = BaseballNumbers.from(Console.readLine());
        mainController.requestHint(baseballNumbers);
    }

    public static void printHint(Hint hint) {
        System.out.println(hint.getMessage());
    }
}
