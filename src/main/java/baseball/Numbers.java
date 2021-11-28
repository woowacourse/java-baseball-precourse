package baseball;

public class Numbers {
    int[] numbers = new int[3];

    public Numbers(int number) {
        convertNumberToArray(number);
    }

    public int getSize() {
        /*
            [definition]
            배열의 사이즈를 반환하는 함수입니다.

            [parameters]
            None

            [return]
            배열의 사이즈
        **/
        return numbers.length;
    }

    public int getIndexingValue(int index) {
        /*
            [definition]
            배열의 특정 인덱스 값을 반환하는 함수입니다.

            [parameters]
            None

            [return]
            배열 인덱싱한 값
        **/
        return numbers[index];
    }

    public boolean isValidNumber() {
        /*
            [definition]
            정의된 수가 유효한 수인지 핀단하는 함수입니다.

            [parameters]
            None

            [return]
            배열 안에 중복된 값이 있거나, 0이 있으면, false
            중복된 값이 없고, 0이 없으면, true

        **/
        return checkDuplicatedNumbers() && checkNotInZero();
    }

    public int[] compareNumberWithInputNumber(Numbers userValue) {
        /*
            [definition]
            랜덤 값과 사용자에게 입력받은 입력 값을 비교하는 합수입니다.

            [parameters]
            userValue: 사용자에게 입력받은 입력 값이 담긴 배열

            - 111 ~ 999 사이의 유효한 값이 전달됨을 보장합니다.

            [return]
            스트라이크, 볼 순으로 각각의 개수를 담은 배열
            만약 하나도 같은 것이 없다면 초기값({0, 0})으로 반환
        **/

        int[] answer = new int[2];

        for(int numbersIndex = 0; numbersIndex < numbers.length; numbersIndex++) {
            for (int userValueIndex = 0; userValueIndex < userValue.getSize(); userValueIndex++) {

                // 같은 위치의 값을 배타연산해서 값이 0인 경우, 해당 값들은 같다고 볼 수 있음
                if ((numbers[numbersIndex] ^ userValue.getIndexingValue(userValueIndex)) == 0) {
                    // 값이 같은데 인덱스가 같다면, 스트라이크 카운팅
                    if ((numbersIndex ^ userValueIndex) == 0) answer[0] += 1;
                        // 같은 같은데 인덱스가 다르다면, 볼 카운팅
                    else answer[1] += 1;
                }
            }
        }

        return answer;
    }

    private void convertNumberToArray(int number) {
        /*
            [definition]
            수를 각각의 자릿수 별로 배열에 담는 함수입니다.

            [parameters]
            number: 변환할 대상
            - 111 ~ 999 사이의 값이 매개변수로 전달됨을 보장합니다.

            [return]
            None

        **/

        this.numbers[0] = number / 100;
        this.numbers[1] = (number % 100) / 10;
        this.numbers[2] = (number % 100) % 10;

    }

    private boolean checkDuplicatedNumbers() {
        /*
            [definition]
            수를 각각의 자릿수 별로 배열에 담아 반환하는 함수입니다.

            [parameters]
            None

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

    private boolean checkNotInZero() {
        /*
            [definition]
            배열에 저장된 수에 0의 값이 없는지 확인하는 함수입니다.

            [parameters]
            None

            [return]
            배열 안에 0 값이 있으면, false
            0 값이 없으면, true

        **/

        for(int number: numbers) {
            if(number == 0) return false;
        }
        return true;
    }
}
