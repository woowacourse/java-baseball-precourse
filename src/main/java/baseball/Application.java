package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        List<Integer> answerNumbersList = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        System.out.println(answerNumbersList);
        while (true) {
            String input = readUserInput();
            validateType(input);
            validateRange(input);
            validateNumber(input);
            List<Integer> inputNumbersList = makeInputToList(input);
            int[] compareResult = compareNumbersList(answerNumbersList, inputNumbersList);
            printHintMessage(compareResult);
            boolean finishGame = isAllNumbersCorrect(compareResult[2]);
            if(finishGame && finishOrNot()){
                break;
            }
        }
    }

    // 사용자로부터 값을 입력받는다.
    private static String readUserInput(){
        return Console.readLine();
    }

    // 인풋에 문자가 포함되어 있는지 확인한다.
    private static void validateType(String inputString) {
        try {
            Integer.parseInt(inputString);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 인풋의 각 자리가 1부터 9까지인지 확인한다.
    private static void validateRange(String inputString) {
        if(inputString.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    // 인풋이 서로 다른 3개의 숫자인지 확인한다.
    private static void validateNumber(String inputString){
        if(inputString.length() != 3 || Arrays.stream(inputString.split("")).distinct().count() != 3){
            throw new IllegalArgumentException();
        }
    }

    // 인풋을 잘라 3사이즈의 리스트에 넣는다.
    private static List<Integer> makeInputToList(String inputString){
        List<Integer> result = new ArrayList<>();
        for(String s : inputString.split("")){
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    // list1(정답 리스트)을 기준으로 두 리스트를 비교한다.
    private static int[] compareNumbersList(List<Integer> list1, List<Integer> list2){
        int[] result = new int[3];
        for(int i = 0; i < 3; i++) {
            int num = list1.get(i);
            if (num == list2.get(i)) {
                result[2] ++; // strike 1개를 추가한다.
            }else if (list2.contains(num)) {
                result[1] ++; // ball 1개를 추가한다.
            }else {
                result[0] ++; // nothing 1개를 추가한다.
            }
        }
        return result;
    }

    // 비교 결과를 바탕으로 힌트를 출력한다.
    private static void printHintMessage(int[] array){
        StringBuilder stringBuilder = new StringBuilder();
        if (array[0] == 3) {
            stringBuilder.append("낫싱");
        } else {
            if (array[1] != 0) {
                stringBuilder.append(array[1]+"볼 ");
            }
            if (array[2] != 0) {
                stringBuilder.append(array[2]+"스트라이크 ");
            }
        }
        System.out.print(stringBuilder);
    }

    // 3스트라이크인지 검사한다.
    private static boolean isAllNumbersCorrect(int strikeCount){
        if(strikeCount == 3){
            return true;
        }
        return false;
    }

    // 3스트라이크일 때 게임을 끝낼 것인지 확인한다.
    private static boolean finishOrNot(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readUserInput();
        if (input.equals("1")) {
            return false;
        } else if (input.equals("2")) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
