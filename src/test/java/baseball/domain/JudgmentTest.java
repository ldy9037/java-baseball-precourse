package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JudgmentTest {
    
    @ParameterizedTest(name = "computer: {0}, player: {1}, expected: {2}")
    @CsvSource(value = {"423:123:2", "812:142:1", "124:732:0"}, delimiter = ':')
    @DisplayName("같은 자리에 같은 숫자가 존재하면 스트라이크 카운트를 증가시킨다.")
    void new_strikeJudgment(String combination1, String combination2, int expected){
        // when
        Judgment strikeJudgment = StrikeJudgment.of(
                new BaseballNumberCombination(generateBaseballNumberList(combination1)),
                new BaseballNumberCombination(generateBaseballNumberList(combination2)));
        
        // then
        assertThat(strikeJudgment.getCount()).isEqualTo(expected);    
    }

    @ParameterizedTest(name = "computer: {0}, player: {1}, expected: {2}")
    @CsvSource(value = {"123:231:3", "812:142:1", "123:123:0"}, delimiter = ':')
    @DisplayName("다른 자리에 같은 숫자가 존재하면 볼 카운트를 증가시킨다.")
    void new_ballJudgment(String combination1, String combination2, int expected){
        // when
        Judgment ballJudgment = BallJudgment.of(
                new BaseballNumberCombination(generateBaseballNumberList(combination1)),
                new BaseballNumberCombination(generateBaseballNumberList(combination2)));
        
        // then
        assertThat(ballJudgment.getCount()).isEqualTo(expected);    
    }

    private List<BaseballNumber> generateBaseballNumberList(String combination) {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();

        for (char number : combination.toCharArray()) {
            baseballNumbers.add(new BaseballNumber(Character.getNumericValue(number)));
        }

        return baseballNumbers;
    }

}
