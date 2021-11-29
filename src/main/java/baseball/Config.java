package baseball;

import baseball.validator.GameInputValidator;
import baseball.validator.PlayOrStopInputValidator;

public class Config {

	GameInputValidator gameInputValidator = new GameInputValidator();

	PlayOrStopInputValidator playOrStopInputValidator = new PlayOrStopInputValidator();

	RandomNumberGenerator randomNumber = new RandomNumberGenerator();

	BallStrikeCalculator ballStrikeCalculator = new BallStrikeCalculator();
}
