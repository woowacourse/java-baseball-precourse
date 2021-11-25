package baseball;

/**
 * <h1>야구게임을 진행할 두 명의 플레이어 중 컴퓨터 플레이어</h1>
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-11-25(V1.0)
 */

public class ComputerPlayer implements Player{

	/** 야구게임 진행을 위해 컴퓨터가 고른 임의의 3자리 난수 */
	private RandomNumber computerSelectedNumber;

	/**
	 * ComputerPlayer 클래스의 새로은 인스턴스를 만든다
	 * 해당 클래스를 사용하는 사용자가 생성자를 사용해 computerSelectedNumber에 대한
	 * 의존성을 주입하지 않을 경우 해당 생성자에서 주입해준다
	 */
	public ComputerPlayer() {
		this(new RandomNumber());
	}

	/**
	 * ComputerPlayer 클래스의 새로운 인스턴스를 만든다
	 *
	 * @param randomNumber 3자리 난수를 스트리으로 만들어 저장하는 인스턴스
	 */
	public ComputerPlayer(RandomNumber randomNumber) {
		this.computerSelectedNumber = randomNumber;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSelectedNumber() {
		return this.computerSelectedNumber.getRandomNumber();
	}
}
