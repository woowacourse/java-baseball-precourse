package baseball;

public class Numbers {

    protected boolean isValidNumber(int[] number) {
        /*
            [definition]
            정의된 수가 유효한 수인지 핀단하는 함수입니다.

            [parameters]
            number: 유효성 검사 대상

            [return]
            배열 안에 중복된 값이 있거나, 0이 있으면, false
            중복된 값이 없고, 0이 없으면, true

        **/
        return checkDuplicatedNumbers(number) && checkNotInZero(number);
    }


    protected int[] convertNumberToArray(int number) {
        /*
            [definition]
            수를 각각의 자릿수 별로 배열에 담는 함수입니다.

            [parameters]
            number: 변환할 대상
            - 111 ~ 999 사이의 값이 매개변수로 전달됨을 보장합니다.

            [return]
            None

        **/
        int[] numbers = new int[3];

        numbers[0] = number / 100;
        numbers[1] = (number % 100) / 10;
        numbers[2] = (number % 100) % 10;

        return numbers;

    }

    private boolean checkDuplicatedNumbers(int[] numbers) {
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

        for(int number: numbers) {
            if((checkArray[number]&1) == 1) return false;
            checkArray[number] += 1;
        }
        return true;
    }

    private boolean checkNotInZero(int[] numbers) {
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
