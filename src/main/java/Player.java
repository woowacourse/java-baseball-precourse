/*
 * Player.java
 *
 */

/**
 * 게임의 진행과 입력을 담당하는 클래스
 */
public class Player {

	/**
	 * player.play() 함수를 반복하면서 게임을 진행
	 * @param args
	 */
	public static void main(String args[]) {
		Player player = new Player();

		/* 일단 1번만 실행 */
		do {
			player.play();
		} while (false);

	}

	/**
	 * 게임을 진행하는 함수
	 */
	private void play() {
		String randomNumber = NumberMaker.makeRandomNumber();
		System.out.println(randomNumber);
	}
}
