package baseball;

import random.Random;

public class Application {

	public static void main(String[] args) {

		Controller controller;

		do {

			controller = new Controller(Random.createAnswer());
			controller.start();

		} while (controller.selectRestartOrExit());
	}
}
