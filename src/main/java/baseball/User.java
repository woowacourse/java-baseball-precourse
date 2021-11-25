package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class User {
    public void printInputMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public String inputPlayerNumber() {
        return Console.readLine();
    }

    public String inputAnswerNumber() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            stringBuilder.append(Randoms.pickNumberInRange(1, 9));
        }

        return stringBuilder.toString();
    }
}
