import java.util.Random;

public class Numbers {
    private static Random random = new Random();

    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public Numbers() {
        firstNumber = makeRandomNumber();
        do {
            secondNumber = makeRandomNumber();
        } while (secondNumber != firstNumber);
        do {
            thirdNumber = makeRandomNumber();
        } while ((thirdNumber != firstNumber) && (thirdNumber != secondNumber));
    }

    public Numbers(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    private int makeRandomNumber() {
        return random.nextInt(9) + 1;
    }

    public boolean hasNumber(int number) {
        if ((firstNumber == number) || (secondNumber == number) || (thirdNumber == number)) {
            return true;
        }
        return false;
    }

    public boolean hasDuplicatedNumber() {
        if ((firstNumber == secondNumber) || (secondNumber == thirdNumber) || (thirdNumber == firstNumber)) {
            return true;
        }
        return false;
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