package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameProviderTest {

    private GameProvider gameProvider;

    @BeforeEach
    void setUp(){
        gameProvider = new GameProvider();
        System.out.println(gameProvider);
    }

    @RepeatedTest(10)
    @DisplayName("정답 확인 - debug")
    @Test
    void checkAnswer(){
        GameScore gameScore = gameProvider.checkAnswer(new int[]{1, 2, 3});
        gameScore.printResult();
    }


}