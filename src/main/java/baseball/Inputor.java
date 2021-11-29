package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

public class Inputor {

    public String inputData() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public String inputRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readLine();
    }

}
