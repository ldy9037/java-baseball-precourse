package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("1,2를 ,로 split 했을 때 배열 {1,2}로 분리된다.")
    void splitString() {
        // given
        String oneCommaTwo = "1,2";
        
        // when
        String[] splitedOneCommaTwo = oneCommaTwo.split(",");

        // then
        assertThat(splitedOneCommaTwo).contains("1", "2");
    }
}
