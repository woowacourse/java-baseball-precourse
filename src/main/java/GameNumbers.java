import java.util.List;
import java.util.stream.Collectors;

public class GameNumbers {
	private List<Number> numbers;

	public GameNumbers(List<Integer> numbers) {
		this.numbers = numbers.stream()
			.map(Number::new)
			.collect(Collectors.toList());
	}
}
