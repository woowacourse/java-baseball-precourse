import java.util.List;

public class BullsAndCows {
    public static void main(String[] args) {
        final int digit = 3;
        RandomNumberGenerator prng = new RandomNumberGenerator(digit);
        List myNumber = prng.generate();

        for (Object it : myNumber)
            System.out.print(it);
        System.out.println();

        //////////////////////////////////////
        InputOutput io = new InputOutput();
        List input = io.getInput(digit);

//        for (Object it: input)
//            System.out.print(it);
    }

}
