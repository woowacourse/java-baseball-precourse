package baseball;

import java.util.stream.Stream;

public class AnswerValidator {

    private static final int NUMBER_LENGTH=3;

    private String answer;

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect(String inputNumber){
        return answer.equals(inputNumber);
    }

    public void checkStrikeAndBall(String input){
        int strike=0;
        int ball=0;
        for(int i=0;i<NUMBER_LENGTH;i++){
            if(isStrike(answer.charAt(i),input.charAt(i))){
                strike++;
            }else if(isBall(input.subSequence(i,i+1))){
                ball++;
            }
        }
        printResult(strike,ball);
    }

    private boolean isStrike(char answer,char input){
        return answer==input;
    }

    private boolean isBall(CharSequence input){
        return answer.contains(input);
    }

    public void printResult(int strike,int ball){
        if(strike==0&&ball==0){
            System.out.println("낫싱");
            return;
        }
        printBallText(ball);
        printStrikeText(strike);
    }

    private void printStrikeText(int strike){
        if(strike==0)return;
        System.out.println(strike+"스트라이크");
    }

    private void printBallText(int ball){
        if(ball==0)return;
        System.out.println(ball+"볼");
    }


}
