package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    
    @Test
    @DisplayName("게임을 상태를 확인한다.")
    void new_game() {
        // when 
        Game game = new Game();

        // then 
        assertThat(game.getStatus()).isEqualTo(GameStatus.IN_PROGRESS);
    }
}