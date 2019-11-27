import Baseball.*;

public class Application {
    public static void main(String[] args) {
        Pitcher pitcher = new PitcherImpl();
        Hitter hitter = new HitterImpl();
        Referee referee = new RefereeImpl();
        BaseballFactory baseballFactory = new NumberBaseballFactory();
        Baseball baseball = baseballFactory.create(pitcher, hitter, referee);

        baseball.start();

    }
}
