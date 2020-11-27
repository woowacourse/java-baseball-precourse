package baseball;

import java.util.List;

public class Computer {
    private List<Integer> randomNumbers;

    Computer(RandomNumberMaker randomNumberMaker) {
        this.randomNumbers = randomNumberMaker.makeRandomNumbers();
    }
}