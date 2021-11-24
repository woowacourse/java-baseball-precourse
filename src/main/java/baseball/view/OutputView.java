package baseball.view;

/**
 * 유저에게 결과를 보여주는 뷰 클래스
 */
public class OutputView {
	private static final String askNumberMessage = "숫자를 입력해주세요 : ";

	/**
	 * 숫자 입력을 요구하는 메시지를 출력하는 함수
	 */
	public static void askNumber() {
		System.out.print(askNumberMessage);
	}

}
