package baseball;

import java.util.List;
import java.util.stream.Stream;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List numbers){
        this.numbers = numbers;
    }

    public Stream<Integer> stream(){
        return numbers.stream();
    }

    public int get(int index){
        return numbers.get(index);
    }

    public int indexOf(Object object){
        return numbers.indexOf(object);
    }

    public boolean contains(Object object){
        return numbers.contains(object);
    }
}
