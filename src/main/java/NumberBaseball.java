import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class NumberBaseball {
	static int[] defenseArr() {
		Set<Integer> set = new LinkedHashSet<>();
		int[] arr = new int[] {0,0,0};
		while(set.size()<3) {
			set.add((int)(Math.random()*9)+1);
		}
		Iterator<Integer> it = set.iterator();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = it.next();
		}
		return arr;
	}
	
	static int[] attackArr(BufferedReader br) {
		int[] ret = new int[] {0,0,0};
		int tmp2 = 0;
		String tmp =null;
		while(true) {
			System.out.print("숫자를 입력해주세요 : ");
			try {
				tmp = br.readLine().trim();
			} catch (IOException e) {}
			
			if(tmp.length()!=3) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			
			try {
				tmp2 = Integer.parseInt(tmp);
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			break;
		}
		for (int i = 2; i >= 0; i--) {
			ret[i] = tmp2 % 10;
			tmp2 /= 10;
		}
		return ret;
	}
}
