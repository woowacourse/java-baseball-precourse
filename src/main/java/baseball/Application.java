package baseball;

import utils.BaseballUtils;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        boolean isRestarted;
        do {
            isRestarted = BaseballRunner.run();;
        }while (isRestarted);

    }
}
