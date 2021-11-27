package baseball.output;

public class Output {
	public static void printRequestNumberInput() {
		System.out.println(PrintMessage.REQUEST_BASEBALL_NUMBER_INPUT_MESSAGE.getMessage());
	}

	public static void printRequestRestartNumberInput() {
		System.out.println(PrintMessage.REQUEST_RESTART_NUMBER_INPUT_MESSAGE.getMessage());
	}

	public static void printBaseballGameResult(String result) {
		System.out.println(result);
	}

	public static void printExceptionMessage(String exceptionMessage) {
		System.out.println(exceptionMessage);
	}

}
