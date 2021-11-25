package baseball;

public class GameProgress {

    public void gameStart() {
        gameProgress();
    }

    public void gameProgress() {
        User user = new User();

        String answer = user.inputAnswerNumber();
        user.printInputMessage();
        String inputNumber = user.inputPlayerNumber();

        while(!answer.equals(inputNumber)){
            user.printInputMessage();
            inputNumber = user.inputPlayerNumber();
        }
    }
}
