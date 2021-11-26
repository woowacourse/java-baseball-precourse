package baseball.messages;

public class PrintResult {

	public void printEndGame(){
		System.out.println(GameMessage.THREE_STRIKE);
		System.out.println(GameMessage.FINISH_GAME);
	}

	public void printNothing() {
		System.out.println(GameMessage.NOTHING);
	}

	public void printBall(int ballCount) {
		String ballCntStr = Integer.toString(ballCount);
		System.out.println(ballCntStr + GameMessage.BALL);
	}

	public void printStrike(int strikeCount) {
		String strikeCntStr = Integer.toString(strikeCount);
		System.out.println(strikeCntStr + GameMessage.STRIKE);
	}

	public void printBallAndStrike(int strikeCount, int ballCount){
		String strikeCntStr = Integer.toString(strikeCount);
		String ballCntStr = Integer.toString(ballCount);
		System.out.println(ballCntStr + GameMessage.BALL + " " +
			strikeCntStr + GameMessage.STRIKE);
	}
}
