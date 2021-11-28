package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    static final int STRIKE = 0;
    static final int BALL = 1;
    static final int NOTHING = 2;

    public static void main(String[] args){
        boolean flag = true;
        String[] resultType = new String[] {"스크라이크", "볼", "낫싱"};

        while (flag) {
            // TODO: 랜덤 수 생성
            int randomValue = Randoms.pickNumberInRange(111, 999);

            // TODO: 생성 된 값 배열로 변환
            int[] randomValueArray = convertNumberToArray(randomValue);

            boolean correct = false;
            while (!correct) {
                // TODO: 사용자 입력 받기
                System.out.print("숫자를 입력해주세요 : ");
                int userInput = Integer.parseInt(Console.readLine());

                // TODO: 사용자 입력 값 배열로 변환
                int[] userInputArray = convertNumberToArray(userInput);

                // TODO: 랜덤 값과 사용자 입력 값 비교
                int[] result = compareRandomValueAndInputValue(randomValueArray, userInputArray);

                // TODO: 비교 결과에 대한 값 출력
                StringBuffer stringBuffer = new StringBuffer();
                // strike = 0, ball = 0
                if((result[STRIKE]|result[BALL]) == 0) System.out.println(resultType[NOTHING]);
                else {
                    for (int index = 0; index < result.length; index++) {
                        if (result[index]==0) continue;
                        if (index > 0) stringBuffer.append(" ");
                        stringBuffer.append(result[index]);
                        stringBuffer.append(resultType[index]);
                    }

                    // strike = 3, ball = 0
                    if((result[STRIKE]^randomValueArray.length) == 0) {
                        stringBuffer.append('\n');
                        stringBuffer.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                        // TODO: 비교 결과에 따른 correct 변수 수정
                        correct = true;
                    }
                }
                    System.out.println(stringBuffer);

            }

            // TODO: 사용자로부터 게임 재게 여부 확인 (1 or 2)
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restart = Integer.parseInt(Console.readLine());

            // TODO: 재게 여부에 따른 flag 변수 수정
            if(restart == 2) flag = false;
        }

    }
    public static Boolean checkDuplicatedNumbers(int[] numbers) {
        /*
            [definition]
            수를 각각의 자릿수 별로 배열에 담아 반환하는 함수입니다.

            [parameters]
            numbers: 판별할 대상
            - 1 ~ 9 사이의 값이 배열에 저장돼 있음을 보장합니다.

            [return]
            배열 안에 중복된 값이 있으면, false
            중복된 값이 없으면, true

        **/
        short[] checkArray = new short[10];

        for(int number = 0; number < numbers.length; number++) {
            if((checkArray[number]&1) == 1) return false;
            checkArray[number] += 1;
        }
        return true;
    }

    public static int[] convertNumberToArray(int number) {
        /*
            [definition]
            수를 각각의 자릿수 별로 배열에 담아 반환하는 함수입니다.

            [parameters]
            number: 변환할 대상
            - 111 ~ 999 사이의 값이 매개변수로 전달됨을 보장합니다.

            [return]
            백의 자리, 십의 자리, 일의 자리 순으로 담은 배열

        **/

        int[] convertedNumber = new int[3];

        convertedNumber[0] = number / 100;
        convertedNumber[1] = (number % 100) / 10;
        convertedNumber[2] = (number % 100) % 10;

        return convertedNumber;

    }

    public static int[] compareRandomValueAndInputValue(int[] randomValue, int[] inputValue) {
        /*
            [definition]
            게임 시작과 동시에 생성한 랜덤 값과 사용자에게 입력받은 입력 값을 비교하는 합수입니다.

            [parameters]
            randomValue: 콤퓨터가 게임의 시작과 동시에 생성한 랜덤 값이 담긴 배열
            inputValue: 사용자에게 입력받은 입력 값이 담긴 배열

            - 111 ~ 999 사이의 값이 매개변수로 전달됨을 보장합니다.
            - 값이 자릿수 별로 배열에 담겨 배열의 형태로 전달됩니다.

            [return]
            스트라이크, 볼 순으로 각각의 개수를 담은 배열
            만약 하나도 같은 것이 없다면 초기값({0, 0})으로 반환
        **/
        int[] answer = new int[2];

        for(int randomValueIndex = 0; randomValueIndex < randomValue.length; randomValueIndex++) {
            for (int inputValueIndex = 0; inputValueIndex < inputValue.length; inputValueIndex++) {

                // TODO: 기능 분리 필요, depth 3 이상
                // 같은 위치의 값을 배타연산해서 값이 0인 경우, 해당 값들은 같다고 볼 수 있음
                if ((randomValue[randomValueIndex] ^ inputValue[inputValueIndex]) == 0) {
                    // 값이 같은데 인덱스가 같다면, 스트라이크 카운팅
                    if ((randomValueIndex ^ inputValueIndex) == 0) answer[0] += 1;
                        // 같은 같은데 인덱스가 다르다면, 볼 카운팅
                    else answer[1] += 1;
                }
            }
        }
        return answer;

    }

}
