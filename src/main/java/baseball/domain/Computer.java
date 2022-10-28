package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    private ArrayList<Integer> computerNumber;

    public void setComputerNumber() {
        computerNumber = new ArrayList<>();

        while(computerNumber.size() != 3) {
            int newNumber = createRandomNumber();

            if(!isDuplicated(newNumber)) {
                computerNumber.add(newNumber);
            }

        }

    }

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public boolean isDuplicated(int number) {
        return computerNumber.contains(number);
    }
}
