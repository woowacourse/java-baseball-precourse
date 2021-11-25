package baseball;

import java.util.List;

import service.Computer;
import camp.nextstep.edu.missionutils.Console;
import service.Converter;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Converter converter = new Converter();
        //TODO: 숫자 야구 게임 구현
        int answer = 0;
        do {
            // 사용자로 부터 문자열 받기
            System.out.print("숫자를 입력해주세요 : ");
            String givenString = Console.readLine();

            // 숫자 리스트로 변환
            List<Integer> givenNumbers = converter.convertStringToIntegerList(givenString);

            // 비교 값 반환
            computer.compareNumbers(givenNumbers);
            // 다 맞추었으면 게임 재시작 여부 물어봄

        } while(answer == 1);

    }
}
