package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballNumberTest {
    
    @ParameterizedTest(name = "num1: {0}, num2: {1}, expected: {2}")
    @CsvSource(value = {"1:1:true", "1:2:false", "3:3:true"}, delimiter = ':')
    @DisplayName("같은 값을 가진 두 BaseballNumber 객체를 비교한다.")
    void equals_baseballNumber_boolean(int number1, int number2, boolean expected) {        
        // when
        BaseballNumber baseballNumberFromNumber1 = new BaseballNumber(number1);
        BaseballNumber baseballNumberFromNumber2 = new BaseballNumber(number2);
        
        // then
        assertThat(baseballNumberFromNumber1.equals(baseballNumberFromNumber2))
                .isEqualTo(expected);
    }
}
