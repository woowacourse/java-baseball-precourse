package baseball.resource.message;

import baseball.resource.rule.NumberDigit;
import baseball.resource.rule.PlayOption;

public class OutputMessage {

	public static final String REQUEST_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
	public static final String REQUEST_PLAY_OR_STOP_MESSAGE = String.format(
			"게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", PlayOption.getRestartOption(), PlayOption.getStopOption());
	public static final String GAME_CLEAR_MESSAGE = NumberDigit.getCount() + "개의 숫자를 모두 맞히셨습니다! 게임 종료";

}
