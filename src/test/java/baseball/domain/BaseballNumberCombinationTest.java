package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballNumberCombinationTest {
    
    private List<BaseballNumber> baseballNumbers;

    @BeforeEach
    void setUp() {
        baseballNumbers = new ArrayList<>();
        baseballNumbers.add(new BaseballNumber(1));
        baseballNumbers.add(new BaseballNumber(2));
        baseballNumbers.add(new BaseballNumber(3));
    }

    @Test
    @DisplayName("숫자 조합을 생성한다.")
    void new_baseballNumberCombination() {
        // when
        BaseballNumberCombination baseballNumberCombination = new BaseballNumberCombination(baseballNumbers);
        
        // then
        assertThat(baseballNumberCombination.getNumber(1))
                .isEqualTo(baseballNumbers.get(1));
    }
}
