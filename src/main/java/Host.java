import java.util.ArrayList;
import java.util.List;

public class Host {

    public static final int baseballGameSize = 3;

    private List<Integer> numbers;

    public static void main(String[] args) {
        Host host = new Host();
        host.generateNumbers();
        System.out.println(host.getNumbers());
    }

    Host() {
        this.numbers = new ArrayList<Integer>();
    }

    public void generateNumbers() {
        while (numbers.size() != baseballGameSize) {
            Integer number = (int) (Math.random() * 10);

            if (number != 0 && !numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }

    public int countNumOfStrikes(List<Integer> inputNumbers) {
        int numOfStrikes = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if ( numbers.get(i).equals(inputNumbers.get(i)) ) {
                numOfStrikes++;
            }
        }
        return numOfStrikes;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
