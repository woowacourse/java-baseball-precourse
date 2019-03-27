
public class PlayTestGame {
	public static void main(String[] args) {
		NumberBaseball nb = new NumberBaseball();
		int[] test = nb.defenseArr();
		for (int i = 0; i < 3; i++) {
			System.out.print(test[i]);
		}
	}
}