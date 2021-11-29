package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public String[] guessDeck() {
        return Console.readLine().split("");
    }
}
