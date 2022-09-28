package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

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

    @Test
    @DisplayName("String 1을 ,로 split 했을 때 1만을 포함하는 배열이 반환된다.")
    void splitMismatchedRegex() {
        // given
        String one = "1";

        // when
        String[] splitedOne = one.split(",");

        // then
        assertThat(splitedOne).containsOnly("1");

    }

    @Test
    @DisplayName("String (1,2)를 1부터 4까지 subString 했을 때 1,2가 반환된다.")
    void substringTo4From1() {
        // given 
        String OneAndTwo = "(1,2)";
        
        // when
        String subStringOneAndTwo = OneAndTwo.substring(1, 4);

        // then 
        assertThat(subStringOneAndTwo).isEqualTo("1,2");
    }
}   
