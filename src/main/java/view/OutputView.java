package view;

public class OutputView {
	private static final String OUTPUT_SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String OUTPUT_EXIT_MESSAGE = "게임이 종료되었습니다. 감사합니다.";
		
	public static void successMessage() {
		System.out.println(OUTPUT_SUCCESS_MESSAGE);
	}
	
	public static void exitMessage() {
		System.out.println(OUTPUT_EXIT_MESSAGE);
	}
	
	public static void show(String message) {
		System.out.println(message);
	}
	
}
