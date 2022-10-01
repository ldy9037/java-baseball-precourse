package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HintTest {

    @ParameterizedTest(name = "computer: {0}, player: {1}, expected: {2}")
    @CsvSource(value = {"123:123:3스트라이크", "123:134:1볼 1스트라이크", "123:456:낫싱"}, delimiter = ':')
    @DisplayName("전체 결과를 확인한다.")
    void getMessage_string(String numbers1, String numbers2, String expected) {
        // when         
        Hint hint = Hint.of(BaseballNumbers.from(numbers1), BaseballNumbers.from(numbers2));

        // then 
        assertThat(hint.getMessage()).isEqualTo(expected);
    }
}
