package baseball;

import baseball.number.Numbers;

public class BaseballGame {
	private final Numbers computer;

	private BaseballGame() {
		this.computer = Numbers.create();
	}

	public static BaseballGame create(){
		return new BaseballGame();
	}

	public Results start(String input){
		Numbers player = Numbers.from(input);
		return Results.of(this.computer,player);
	}
}
