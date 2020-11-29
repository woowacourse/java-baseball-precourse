package baseball;

import utils.RandomUtils;

public class Opponent {
    public String opponentNumber;

    /* opponent 난수 생성 메소드 */
    public String generateNumber() {
        String opponentNumber = "";
        while(opponentNumber.length()<3) {
            int randomNumber = RandomUtils.nextInt(1, 9);
            if(!opponentNumber.contains(String.valueOf(randomNumber))) {
                opponentNumber += randomNumber;
            }
        }
        this.opponentNumber = opponentNumber;
        return opponentNumber;
    }


}
