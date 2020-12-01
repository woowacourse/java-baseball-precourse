package baseball;

public class AskQuestion {

    public static final String GO = "1";
    public static final String STOP = "2";

    private boolean keepGoing = true;
    private boolean isValidInput = false;

    public boolean getKeepGoing() {
        return keepGoing;
    }

    public boolean getIsVaildInput() {
        return isValidInput;
    }

    // if keepGoing has false value, stop playing game
    public void setKeepGoing(boolean input) {
        keepGoing = input;
    }

    public void setIsValidInput(boolean input) {
        isValidInput = input;
    }

    public void ask() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void askResponse(GameData gameData, String input) {
        if (input.equals(GO)) {
            setIsValidInput(true);
            // if start a game again, reset random values
            gameData.selectRandomNumber();
        } else if (input.equals(STOP)) {
            setIsValidInput(true);
            setKeepGoing(false);
            System.out.println("게임을 종료하겠습니다.");
        } else {
            System.out.println("유효하지 않은 입력입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}