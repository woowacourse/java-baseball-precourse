package baseball;

import java.util.Scanner;

public class BaseBallGame {

    private static final String NEW_GAME="1";

    private static final String EXIT="2";

    private static final String INPUT_ERROR="입력오류";

    private Scanner sc = new Scanner(System.in);

    private AnswerValidator answerValidator;

    private User user;

    private String answer;

    public BaseBallGame(){
        answerValidator =new AnswerValidator();
        user=new User();
    }

    public void run(){
        while(true){
            if(!isRun()){
                OutputView.gameExitText();
                break;
            }
            reset();
            start();
        }
    }

    private boolean isRun(){
        String input=InputView.getNewGameOrExit();
        if(!input.equals(NEW_GAME)&&!input.equals(EXIT)){
            throw new IllegalArgumentException(INPUT_ERROR);
        }
        return input.equals(NEW_GAME);
    }

    public void reset(){
        answer=RandomNumberGenerator.generate();
        answerValidator.setAnswer(answer);
    }

    public void start(){
        while(true){
            String input=user.inputNumber();
            if(answerValidator.isCorrect(input)){
                OutputView.gameFinishText();
                break;
            }else{
                answerValidator.checkStrikeAndBall(input);
            }
        }
    }
}
