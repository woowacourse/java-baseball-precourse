package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class ApplicationTest extends BaseTest{
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 낫싱() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("246");
            verify("낫싱");
        }
    }

    @Test
    void 게임종료_후_재시작() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(7, 1, 3)
                    .thenReturn(5, 8, 9);
            run("713", "1", "597", "589", "2");
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
