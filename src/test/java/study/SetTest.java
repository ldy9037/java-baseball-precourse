package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SetTest {
    
    private Set<Integer> numbers;

    @BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);	
	}

    @Test
    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인한다.")
    void size_int() {
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }
}
