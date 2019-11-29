import Baseball.*;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Baseball baseball = setupBaseball();
        baseball.play();
    }
    private static Baseball setupBaseball() {
        Hitter hitter = new NumberHitter();
        Scanner scanner = new Scanner(System.in);
        Pitcher pitcher = new NumberPitcher(scanner);
        Referee referee = new NumberReferee();
        BaseballFactory baseballFactory = new NumberBaseballFactory();
        return baseballFactory.create(hitter, pitcher, referee);
    }
}
