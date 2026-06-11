package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

    @Test
    @DisplayName("거터 게임은 0점이다")
    void gutterGameScoresZero() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    @DisplayName("모든 투구가 1점이면 20점이다")
    void allOnesScoresTwenty() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    @DisplayName("스페어 후 다음 투구가 보너스로 더해진다")
    void oneSpareAddsNextRollAsBonus() {
        game.roll(5);
        game.roll(5); // spare
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    @DisplayName("스트라이크 후 다음 두 투구가 보너스로 더해진다")
    void oneStrikeAddsNextTwoRollsAsBonus() {
        game.roll(10); // strike
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    @DisplayName("퍼펙트 게임은 300점이다")
    void perfectGameScoresThreeHundred() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }
}
