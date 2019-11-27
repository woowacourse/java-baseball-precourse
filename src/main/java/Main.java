import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        HashMap<Integer, Integer> numberMap = numberGenerator.generateNumbers();
        System.out.println("임의의 수: " + numberMap.toString());
    }
}
