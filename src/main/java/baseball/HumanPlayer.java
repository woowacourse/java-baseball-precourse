package baseball;


/**
 * <h1>숫자야구게임을 진행할 두 명의 플레이어 중 사람 플레이어</h1>
 *
 * @author yunki kim
 * version 1.0
 * @since 2021-11-25(V1.0
 */

public class HumanPlayer implements Player {

	/** 숫자야구게임 진행을 위해 사람이 고른 임의의 3자리 자연수 */
	private String humanSelectedNumber;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSelectedNumber() {
		return this.humanSelectedNumber;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSelectedNumber(String selectedNumber) throws IllegalArgumentException{
		if(!Player.validateSelectedNumber(selectedNumber)) {
			throw new IllegalArgumentException("유효하지 않은 숫자형식입니다.");
		}
		this.humanSelectedNumber = selectedNumber;
	}
}
