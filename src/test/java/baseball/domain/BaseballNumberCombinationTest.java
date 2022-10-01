package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballNumberCombinationTest {
    
    private List<BaseballNumber> baseballNumbers;

    @BeforeEach
    void setUp() {
        baseballNumbers = generateBaseballNumberList(BaseballNumberCombination.NUMBER_SIZE);
    }

    @Test
    @DisplayName("숫자 조합을 생성한다.")
    void new_baseballNumberCombination() {
        // when
        BaseballNumberCombination baseballNumberCombination = BaseballNumberCombination.of(baseballNumbers);
        
        // then
        assertThat(baseballNumberCombination.getNumber(1))
                .isEqualTo(baseballNumbers.get(1));
    }

    @Test
    @DisplayName("중복된 숫자가 존재할 경우 에러가 발생한다.")
    void validate_duplicateNumber_exception() {
        // when 
        baseballNumbers.set(1,baseballNumbers.get(0));
        
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumberCombination.of(baseballNumbers))
                .withMessageMatching(
                        ErrorMessage.BASEBALL_NUMBER_DUPLICATE_ERROR.getMessage());
    }

    @ParameterizedTest(name = "size: {arguments}")
    @ValueSource(ints = {BaseballNumberCombination.NUMBER_SIZE - 1, BaseballNumberCombination.NUMBER_SIZE + 1})
    @DisplayName("잘못된 크기의 숫자 조합을 생성하면 에러가 발생한다.")
    void validate_worngNumberSize_exception(int size) {
        // when
        List<BaseballNumber> worngSizeList = generateBaseballNumberList(size);

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumberCombination.of(worngSizeList))
                .withMessageMatching("숫자는 %d자리 조합만 허용됩니다.".replace("%d", "\\d+"));
    }

    private List<BaseballNumber> generateBaseballNumberList(int size) {
        List<BaseballNumber> result = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            result.add(new BaseballNumber(i));
        }

        return result;
    }
}
