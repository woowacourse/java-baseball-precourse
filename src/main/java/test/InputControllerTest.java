package test;

import baseball.controller.InputController;

import java.util.List;
import java.util.Scanner;

public class InputControllerTest {

    /*
    * 직접 Scanner를 이용해 InputController 작동 테스트
    * 1. Validator 작동 여부
    * 2. 입력값이 옳지 않을 경우, 다시 input()을 호출 계속 입력값을 받도록 작동
    * 3. 제대로 입력했을 경우 String input -> List<Integer> 변환
    * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InputController inputController = new InputController(sc);

        List<Integer> numbers = inputController.input();

        System.out.println(numbers.toString());

    }

}
