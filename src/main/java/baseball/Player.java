package baseball;

/**
 * <h1>숫자 야구게임 플레이어에 대한 인터페이스이다</h1>
 * 플레이어를 만들떄 이 인터페이스를 사용해 만든다
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-11-25
 */

public interface Player {

	/**
	 * 플레이어들이 고른 숫자야구게임에서 사용할 수를 가져온다
	 *
	 * @return String 플레이어 들이 고른 3자리 수
	 */
	String getSelectedNumber();
}
