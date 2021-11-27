package baseball;

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


}
