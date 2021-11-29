package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;

public class Application {

	public static void main(String[] args) {
		BaseballService baseballService = new BaseballService();
		BaseballController baseballController = new BaseballController(baseballService);
		baseballController.run();
	}

}
