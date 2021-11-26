package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

class UniqueNumberFactoryTest {

    @Test
    public void 중복_없는_숫자를_생성할_수_있다() {
        // 9개 중에서 중복 없이 3개 뽑기 테스트
        // 몇번을 반복 검증해야 검증 되었다고 할 수 있을까?
        // 테스트 코드를 실행할 때 마다 반복할 텐데 좋은걸까?
        // HashSet은 솔직히 믿고 써도 되는거 아닐까?
        // 그런데 누군가가 HashSet을 바꿔버릴 수도 있으니까 유지해야되나?
        for (int i = 0; i < 100; i++) {
            List<Integer> uniqueNumber = UniqueNumberFactory.create();
            boolean actual = isDuplicated(uniqueNumber);
            assertFalse(actual);
        }
    }

    private boolean isDuplicated(List<Integer> uniqueNumber) {
        int i = uniqueNumber.get(0);
        int j = uniqueNumber.get(1);
        int k = uniqueNumber.get(2);

        return equal(i, j) || equal(i, k) || equal(j, k);
    }

    private boolean equal(int i, int j) {
        return Objects.equals(i, j);
    }

}