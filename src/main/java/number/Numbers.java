package number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
