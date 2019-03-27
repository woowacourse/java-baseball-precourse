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
}
