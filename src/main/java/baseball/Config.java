package baseball;

import baseball.inputchecking.GameInputChecking;
import baseball.inputchecking.PlayOrStopInputChecking;

public class Config {

	GameInputChecking gameInputChecking = new GameInputChecking();

	PlayOrStopInputChecking playOrStopInputChecking = new PlayOrStopInputChecking();

	RandomNumber randomNumber = new RandomNumber();

	BallStrikeCalculator ballStrikeCalculator = new BallStrikeCalculator();
}
