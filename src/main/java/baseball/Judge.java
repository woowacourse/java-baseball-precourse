package baseball;

public class Judge {

	private int strike;
	private int ball;

	Judge() {
		this.strike = 0;
		this.ball = 0;
	}

	public boolean Judgement(int[] randomNumber, int[] userNumber){

		this.strike = judgeStrike(randomNumber, userNumber);
		this.ball = judgeBall(randomNumber, userNumber);

		
		if (this.strike != 0 && this.ball != 0)
			System.out.println(this.ball + "볼 " + this.strike + "스트라이크");
		else if (this.strike == 0 && this.ball != 0)
			System.out.println(this.ball + "볼");
		else if (this.strike != 0 && this.ball == 0)
			System.out.println(this.strike + "스트라이크");
		else {
			System.out.println("낫싱");
		}
		return false;

	}

	public int judgeBall(int[] randomNumber, int[] userNumber){


		for(int i = 0; i < randomNumber.length; i++){
			for(int j = 0; j< userNumber.length; j++){
				this.ball += isEqual(randomNumber[i], userNumber[j]);
			}
		}

		this.ball -= this.strike;

		return this.ball;
	}

	public int judgeStrike(int[] randomNumber,int[] userNumber){

		for(int i = 0; i < randomNumber.length; i++){
			this.strike += isEqual(randomNumber[i], userNumber[i]);
		}

		return this.strike;
	}

	public static int isEqual(int A, int B){
		if(A == B){
			return 1;
		}
		return 0;
	}
}
