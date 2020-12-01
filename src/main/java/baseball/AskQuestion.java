package baseball;

public class AskQuestion {

    public static final int GO = 1;
    public static final int STOP = 2;

    private boolean keepGoing = true;

    public boolean getKeepGoing() {
        return keepGoing;
    }

    // if keepGoing has false value, stop playing game
    public void setFalseKeepGoing() {
        keepGoing = false;
    }

    public void ask() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void askResponse(GameData gameData, int input) {
        if (input == GO) {
            // if start a game again, reset random values
            gameData.selectRandomNumber();
        } else {
            setFalseKeepGoing();
            System.out.println("게임을 종료하겠습니다.");
        }
    }

}