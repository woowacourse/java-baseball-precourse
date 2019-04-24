import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ComNumReceiver {

	/*
	 * 임의의 값 3개를 정해 3자리 수로 만들어 주는 메소드
	 * 
	 * @return 임의의 세자리수
	 */
	public static int receive() {

		List<Integer> comNums = new Random().ints(1, 9).distinct().limit(3).boxed().collect(Collectors.toList());
		return (comNums.get(0) * 100 + comNums.get(1) * 10 + comNums.get(2));
	}
}
