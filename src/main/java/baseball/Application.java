package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    static final int STRIKE = 0;
    static final int BALL = 1;
    static final int NOTHING = 2;

    static String[] resultType = new String[] {"스크라이크", "볼", "낫싱"};

    public static void main(String[] args){
        boolean flag = true;

        while (flag) {

            // 랜덤 수 생성, 유효한 값이 아닐 경우 반복 생성.
            Numbers randomValueArray;
            do {
                randomValueArray = new Numbers(createRandom(3));
            } while(!randomValueArray.isValidNumber());

            boolean correct = false;
            while (!correct) {
                // 사용자 입력 받기
                System.out.print("숫자를 입력해주세요 : ");
                int userInput = Integer.parseInt(Console.readLine());

                // 만약 1000이 넘어가는 값 입력 받았을 시, 종료
                if(userInput / 100 >= 10) throw new IllegalArgumentException("유효하지 않은 입력값(1000 이상)");

                // 사용자 입력 값 배열로 변환
                Numbers userInputArray = new Numbers(userInput);
                if(!userInputArray.isValidNumber()) throw new IllegalArgumentException("유효하지 않은 입력값");

                // 랜덤 값과 사용자 입력 값 비교
                int[] result = randomValueArray.compareNumberWithInputNumber(userInputArray);
                correct = printResult(result,3);

            }

            // 사용자로부터 게임 재게 여부 확인 (1 or 2)
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restart = Integer.parseInt(Console.readLine());

            if(!(restart == 1 || restart == 2)) throw new IllegalArgumentException("유효하지 않은 입력값");

            // 재게 여부에 따른 flag 변수 수정
            if(restart == 2) flag = false;
        }

    }
    public static int createRandom(int count){
         /*
            [definition]
            게임 시작 시, 랜덤값을 생성해 반환합니다.

            [parameters]
            count: 생성할 랜덤값 자릿수

            [return]
            생성된 랜덤 수
        **/
        int randomNumber = 0;
        randomNumber += Randoms.pickNumberInRange(1, 9) * 100;
        randomNumber += Randoms.pickNumberInRange(1, 9) * 10;
        randomNumber += Randoms.pickNumberInRange(1, 9);

        return randomNumber;

    }

    public static boolean printResult(int[] result, int randomValueSize) {
         /*
            [definition]
            비교 결과에 대한 내용을 출력합니다.

            [parameters]
            result: 비교한 결과
            randomValueSize: 콤퓨터가 게임의 시작과 동시에 생성한 랜덤 값이 담긴 배열의 사이즈

            [return]
            3스트라이크의 경우, true
            그 외, false
        **/
        boolean correct = false;
        StringBuilder stringBuilder = new StringBuilder();

        // strike = 0, ball = 0
        if((result[STRIKE]|result[BALL]) == 0) {
            System.out.println(resultType[NOTHING]);
            return correct;
        }

        for (int index = 0; index < result.length; index++) {
            if (result[index]==0) continue;
            stringBuilder.append(result[index]);
            stringBuilder.append(resultType[index]);
            stringBuilder.append(" ");
        }
        // 마지막 띄어쓰기 제거
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        // strike = 3, ball = 0
        if((result[STRIKE]^randomValueSize) == 0) {
            stringBuilder.append('\n');
            stringBuilder.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            // 비교 결과에 따른 correct 변수 수정
            correct = true;
        }

        System.out.println(stringBuilder);
        return correct;
    }

}
