import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Numbers {
    private static Random random = new Random();

    private Number firstNumber;
    private Number secondNumber;
    private Number thirdNumber;

    public Numbers() {
        makeFirstNumber();
        makeSecondNumber();
        makeThirdNumber();
    }

    public Numbers(int firstValue, int secondValue, int thirdValue) {
        this.firstNumber = new Number(1, firstValue);
        this.secondNumber = new Number(2, secondValue);
        this.thirdNumber = new Number(3, thirdValue);
    }

    private void makeFirstNumber() {
        firstNumber = new Number(1, makeRandomNumber());
    }

    private void makeSecondNumber() {
        do {
            secondNumber = new Number(2, makeRandomNumber());
        } while (!secondNumber.isSameValue(firstNumber));
    }

    private void makeThirdNumber() {
        do {
            thirdNumber = new Number(3, makeRandomNumber());
        } while ((!thirdNumber.isSameValue(firstNumber)) && (!thirdNumber.isSameValue(secondNumber)));
    }

    private int makeRandomNumber() {
        return random.nextInt(9) + 1;
    }

    public boolean hasNumber(int number) {
        if ((firstNumber.isSameValue(number)) || (secondNumber.isSameValue(number)) || (thirdNumber.isSameValue(number))) {
            return true;
        }
        return false;
    }

    public boolean hasDuplicatedNumber() {
        return true;
    }

    public ResultOfComparison compareWith(Numbers numbersFromUser) {
        // 비교하고 결과 출력하기
        // 비교값을 담는 객체 별도 생성

        int strike = countStrike(numbersFromUser);
        int ball = countBall(numbersFromUser);

        if ((strike == 0) && (ball == 0)) {
            System.out.println("낫싱");
            return null;
        }

        System.out.println(strike + " 스트라이크 " + ball + " 볼");

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return null;
    }

    public int countStrike(Numbers numbers) {
        int strike = 0;
        if (this.firstNumber == numbers.firstNumber) {
            strike++;
        }
        if (this.secondNumber == numbers.secondNumber) {
            strike++;
        }
        if (this.thirdNumber == numbers.thirdNumber) {
            strike++;
        }
        return strike;
    }

    public int countBall(Numbers numbers) {
        int ball = 0;
        if ((this.firstNumber == numbers.secondNumber) || (this.firstNumber == numbers.thirdNumber)) {
            ball++;
        }
        if ((this.secondNumber == numbers.firstNumber) || (this.secondNumber == numbers.thirdNumber)) {
            ball++;
        }
        if ((this.thirdNumber == numbers.firstNumber) || (this.thirdNumber == numbers.secondNumber)) {
            ball++;
        }
        return ball;
    }
}

class Number {

    private int index;
    private int value;

    Number(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public boolean isSameIndex(int index) {
        return this.index == index;
    }

    public boolean isSameIndex(Number number) {
        return this.index == number.index;
    }

    public boolean isSameValue(int value) {
        return this.value == value;
    }

    public boolean isSameValue(Number number) {
        return this.value == number.value;
    }


}