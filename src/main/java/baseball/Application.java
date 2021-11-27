package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

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
