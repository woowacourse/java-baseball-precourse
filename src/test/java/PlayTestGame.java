public class PlayTestGame {
	public static void main(String[] args) {
		int[] result = NumberBaseball.attackResult(new int[] {3,2,1}, new int[] {1,2,3});
		System.out.print("Strike : " + result[0] + ", Ball :" + result[1]);
	}
}