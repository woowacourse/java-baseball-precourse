package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ValidTest {


    @Test
    void newTargetTest() throws Exception {
        Valid valid = new Valid();
        ArrayList<String> numbers = new ArrayList<>();
        String testNumber;
        for (int i = 111; i < 1000; i++) {
            testNumber = String.valueOf(i);
            if (testNumber.contains("0") ||
                    testNumber.charAt(0) == testNumber.charAt(1) ||
                    testNumber.charAt(0) == testNumber.charAt(2) ||
                    testNumber.charAt(1) == testNumber.charAt(2)) {
                continue;
            }
            numbers.add(testNumber);
        }
        int range = numbers.size();
        System.out.println(range);

        while (!numbers.isEmpty()) {
            testNumber = valid.newTarget();
            if ((Integer.parseInt(testNumber) < 111) &&
                    (Integer.parseInt(testNumber) > 999)) {
                throw new IllegalArgumentException();
            }
            numbers.remove(testNumber);
        }
        System.out.println("Test passed");
    }
}