package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import static baseball.InputException.validatesNumber;

public class Player {
    private final List<Integer> inputNumber;

    public Player() {
        this.inputNumber = new ArrayList<>();
    }

    public void playerInputNumber() {    // 사용자 입력 메서드
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validatesNumber(input);

        inputNumber.clear();    // 이전 입력값 지우기
        for (char ch : input.toCharArray()) {   // 입력받은 숫자를 리스트에 저장
            inputNumber.add(Character.getNumericValue(ch));
        }
    }

    public List<Integer> getInputNumber(){
        return this.inputNumber;
    }

    // 게임 재시작 여부
    public String inputReplay(){
        String inputReplay = Console.readLine();
        return inputReplay;
    }
}
