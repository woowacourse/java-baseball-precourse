package baseball;

import camp.nextstep.edu.missionutils.Console;

/**
 * <h1>숫자야구게임 로직</h1>
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-11-25(V1.0)
 */

public class BaseballGame {

	/** 사람 플레이어가 3자리 수를 모두 맞추었을때 반환되는 스트링 */
	public static final String CORRECT_ANSWER = "3스트라이크";

	/** 사람 플레이어의 추측이 틀렸을때 반환되는 스트링 */
	public static final String WRONG_ANSWER = "";

	/** 정답을 맞춘 후 게임 재시작함을 의미하는 사람플레이어의 입력 */
	public static final String RESTART_GAME = "1";

	/** 사람 플레이어 */
	private Player humanPlayer;

	/** 컴퓨터 플레이어 */
	private Player computerPlayer;

	/**
	 * BaseballGame 인스턴스 생성자
	 * 인스턴스 생성시 humanPlayer와 computerPlayer의 인스턴스를 인자로 넘기지 않는다면
	 * 해당 생성자에서 인자로 넘겨준다
	 */
	public BaseballGame() {
		this(new HumanPlayer(), new ComputerPlayer());
	}

	/**
	 * BaseballGame 인스턴스 생성자
	 * @param humanPlayer 숫자야구개임 사람 플레이어
	 * @param computerPlayer 숫자야구개임 컴퓨터 플레이어
	 */
	public BaseballGame(final Player humanPlayer, final Player computerPlayer) {
		this.humanPlayer = humanPlayer;
		this.computerPlayer = computerPlayer;
	}

	/**
	 * 사람 플레이어가 숫자를 고른다
	 *
	 * @throws IllegalArgumentException 사용자가 3자리 자연수형태의 스트링을 입력하지 않으면 발생 후 종료
	 */
	private void humanSelectNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		final String selectedNumber = Console.readLine();
		try {
			humanPlayer.setSelectedNumber(selectedNumber);
		} catch(IllegalArgumentException wrongNumberFormat) {
			System.out.println(wrongNumberFormat);
			System.exit(0);
		}
	}

	/**
	 * 사람 플레이어가 고른 수에서 볼의 갯수에 대한 결과를 만든다
	 * 만약 볼이 없으면 빈 문자열을 반환한다
	 *
	 * @param ballCount ball의 갯수
	 * @return String 볼의 갯수를 알려주는 문자열
	 */
	private String makeBallResult(final Integer ballCount) {
		if(ballCount <= 0) {
			return "";
		}
		return ballCount + "볼 ";
	}

	/**
	 * 사람 플레이어가 고른 수에서 스트라이크 갯수에 대한 결과를 만든다
	 * 만약 스트라이크가 없으면 빈 문자열을 반환한다
	 *
	 * @param strikeCount 스트라이크의 갯수
	 * @return String 스트라이크의 갯수를 알려주는 문자열
	 */
	private String makeStrikeResult(final Integer strikeCount) {
		if(strikeCount <= 0) {
			return "";
		}
		return strikeCount + "스트라이크 ";
	}

	/**
	 * 사람플레이어와 컴퓨터플레어이가 고른 수를 비교해서 결과를 출력한다
	 * 고른 수가 맞다면 CORRECT_ANSWER를, 아니라면 WRONG_ANSWER를 반환한다
	 *
	 * @return String 사람플레이어가 고른 수에 대한 숫자야구게임 결과
	 */
	private String judgeHumanSelectedNumber() {
		final String humanSelectedNumber = humanPlayer.getSelectedNumber();
		final String computerSelectedNumber = computerPlayer.getSelectedNumber();
		String result = "";
		int ballCount = 0;
		int strikeCount = 0;

		/* 스트라이크 갯수 카운트 */
		for(int idx = 0; idx < 3; idx++) {
			final char humanSingleNumber = humanSelectedNumber.charAt(idx);
			final char computerSingleNumber = computerSelectedNumber.charAt(idx);
			if(humanSingleNumber == computerSingleNumber) {
				strikeCount++;
			}
		}

		if(strikeCount == 3) {
			return CORRECT_ANSWER;
		}

		/* 볼 갯수 카운트 */
		for(int humanIdx = 0; humanIdx < 3; humanIdx++) {
			final char singleNumber = humanSelectedNumber.charAt(humanIdx);
			if((computerSelectedNumber.contains(Character.toString(singleNumber)))
				&& (computerSelectedNumber.indexOf(singleNumber) != humanIdx)) {
				ballCount++;
			}
		}

		result = makeBallResult(ballCount) + makeStrikeResult(strikeCount);
		if(result.isEmpty()) {
			result = "낫싱";
		}
		System.out.println(result);
		return WRONG_ANSWER;
	}


	/**
	 * 숫자야구게임을 재시작할지 또는 끝낼지를 결정한다
	 * 만약 사람플레이어가 1을 입력하면 재시작
	 * 만약 사람플레이어가 2를 입력하면 종료
	 *
	 * @return Boolean 야구게임을 재시작할지 여부, true면 재시작, false면 종료
	 */
	private boolean selectRestartOrTerminate() {
		String humanPlayerOpinion;
		System.out.println(CORRECT_ANSWER);
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		humanPlayerOpinion = Console.readLine();
		if(humanPlayerOpinion.equals(RESTART_GAME)) {
			computerPlayer = new ComputerPlayer(new RandomNumber());
		}
		return humanPlayerOpinion.equals(RESTART_GAME);
	}

	/**
	 * 실제 숫자야구게임 로직이 구동되는 메서드
	 * 이 메서드를 호출하면 숫자야구게임이 시작된다
	 */
	public void StartBaseballGame() {
		boolean restartGame = true;
		while(restartGame) {
			humanSelectNumber();
			if(judgeHumanSelectedNumber().equals(CORRECT_ANSWER)) {
				restartGame = selectRestartOrTerminate();
			}
		}
	}
}
