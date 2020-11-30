package baseball;

public class Discriminator {
    private static final int NUMBER_LENGTH = 3;
    private int strike = 0;
    private int ball = 0;

    public boolean judge(Digits answer, Digits userInput) {
        for (int i = 0; i < NUMBER_LENGTH; i++){
            for (int j = 0; j < NUMBER_LENGTH; j++) {
                compare(i, answer.indexOfDigit(i), j, userInput.indexOfDigit(j));
            }
        }
        printResult();
        return strike != NUMBER_LENGTH;
    }

    private void compare(int answerIndex, int answerDigit, int inputIndex, int inputDigit) {
        if (answerDigit == inputDigit){
            if (answerIndex == inputIndex){
                strike++;
            }else{
                ball++;
            }
        }
    }

    private void printResult() {
        if(ball !=0 && strike != 0){
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }else if (strike != 0){
            System.out.println(strike + "스트라이크");
        }else if (ball != 0){
            System.out.println(ball + "볼");
        }else {
            System.out.println("낫싱");
        }
    }
}
