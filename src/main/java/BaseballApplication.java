import domain.BaseballGame;
import domain.BaseballNumberRepository;

public class BaseballApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseballNumberRepository baseballNumberRepository = new BaseballNumberRepository();
		BaseballGame baseballGame = new BaseballGame(baseballNumberRepository);
		baseballGame.play();
	}

}
