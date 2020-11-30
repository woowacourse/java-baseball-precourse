package baseball;

import utils.RandomUtils;

public class Opponent {
    private String opponentNumber;

    private static final int START_INCLUSIVE = 1;

    private static final int END_INCLUISIVE = 9;

    private static final int BASEBALL_NUMBER_LENGTH = 3;

    /* opponent 난수 생성 메소드 */
    public void generateNumber() {
        String opponentNumber = "";
        while (opponentNumber.length() < BASEBALL_NUMBER_LENGTH) {
            String randomNumber = String.valueOf(RandomUtils.nextInt(START_INCLUSIVE, END_INCLUISIVE));
            if (!opponentNumber.contains(randomNumber)) {
                opponentNumber += randomNumber;
            }
        }
        this.opponentNumber = opponentNumber;
    }

    public String getOpponentNumber() {
        return opponentNumber;
    }
}
