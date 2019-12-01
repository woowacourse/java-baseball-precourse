package main.java;

public class Main {
	public static void main (String[] args) {
		Computer computer = new Computer();
		User user = new User();
		Matching matching = new Matching();
		Result result = new Result();
		
		int[] target = computer.make_list();
		int[] success = new int[2];
		
		while (true) {
			int[] answer = user.input();
			
			int strike = matching.strike(target, answer);
			int ball = matching.ball(target, answer);
			
			success = result.release(strike, ball);
			
			if (success[0] == 1) {
				break;
			}
		}
		
		if (success[1] == 1) {
			main(args);
		}
	}
	
}
