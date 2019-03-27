import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlayTestGame {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		NumberBaseball.playGame(br);;
	}
}