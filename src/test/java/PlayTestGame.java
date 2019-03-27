import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlayTestGame {
	public static void main(String[] args) {
		NumberBaseball nb = new NumberBaseball();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] test = nb.attackArr(br);
		for (int i = 0; i < 3; i++) {
			System.out.print(test[i]);
		}
	}
}