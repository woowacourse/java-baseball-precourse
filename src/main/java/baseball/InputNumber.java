package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {

    /**
     * 사용자 입력 숫자를 배열로 받습니다.
     * 0번째 : 백의 자리
     * 1번째 : 십의 자리
     * 2번째 : 일의 자리
     * */
    private  int[] inputArray;

    /**
     * 숫자 입력 받는 함수
     * 그 후 각 자리에 맞게 배열에 저장합니다.
     * */
    private int inputNum(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        exception(input); // 예외 처리
        int inputNum = Integer.parseInt(input);
        inputArray = new int[]{inputNum / 100, (inputNum % 100) / 10, inputNum % 10};
        return inputNum;
    }

    /**
     * 예외처리
     * 1. 3자리 수가 아니면 예외 발생
     * 2. 0~9 이외의 수가 존재하면 예외 처리
     * */
    private void exception(String input){
        // 1번
        if(input.length() != 3){
            throw new IllegalArgumentException("세자리의 숫자를 입력해주어야 합니다");
        }

        // 2번
        final String REGEX = "[0-9]+";
        if(!input.matches(REGEX)){
            throw new IllegalArgumentException("0~9 이외의 숫자는 입력하실 수 없습니다.");
        }

    }

    /**
     * inputArray 받아오기
     * RandomNumber 클래스와 마찬가지로 배열값만 외부 클래스에서 접근가능하도록 제한
     * */
    public int[] getInputArray() {
        inputNum();
        return inputArray;
    }
}