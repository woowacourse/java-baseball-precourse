package com.teco;


import java.util.*;

/**
 * 숫자 야구 게임이 진행되는 클래스
 *
 * @author 김성훈
 * @version 1.0
 */
class Game {
    private UserInterface userInterface;
    private RandomNumberGenerator randomNumberGenerator;

    Game(UserInterface userInterface, RandomNumberGenerator randomNumberGenerator) {
        this.userInterface = userInterface;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    void play() {
        Calculation calculation = new Calculation(initComRandomNumbers());
        StrikeBall strikeBall;
        do {
            strikeBall = calculation.calcStrikeAndBall(initUserRandomNumbers());
            userInterface.printResult(makeResultByString(strikeBall));
        } while (calculation.checkThreeStrike(strikeBall));
        userInterface.printEndMessage();
        if (decideEndOrNot()) {
            play();
        }
    }

    private Map<Integer, Integer> initComRandomNumbers() {
        try {
            return new RandomNumbers(randomNumberGenerator.makeThreeRandomNumbers())
                    .setRandomNumbersToMap();
        } catch (Exception e) {
            return initComRandomNumbers();
        }
    }

    private Map<Integer, Integer> initUserRandomNumbers() {
        try {
            return new RandomNumbers(parseStringArrayToSet(userInterface.getUserRandomNumber()))
                    .setRandomNumbersToMap();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return initUserRandomNumbers();
        }
    }

    private Set<Integer> parseStringArrayToSet(String[] userInputArr) {
        try {
            Set<Integer> userRandomNumbersSet = new LinkedHashSet<>();
            for (String userInput : userInputArr) {
                userRandomNumbersSet.add(new RandomNumber(Integer.parseInt(userInput)).getRandomNumber());
            }
            return userRandomNumbersSet;
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
    }

    private String makeResultByString(StrikeBall strikeBall) {
        StringBuilder stringBuilder = new StringBuilder();
        if (strikeBall.getStrike() != 0) {
            stringBuilder.append(strikeBall.getStrike() + "S ");
        }
        if (strikeBall.getBall() != 0) {
            stringBuilder.append(strikeBall.getBall() + "B ");
        }
        if (strikeBall.getStrike() == 0 && strikeBall.getBall() == 0) {
            stringBuilder.append("낫싱");
        }
        return stringBuilder.toString();
    }

    private boolean decideEndOrNot() {
        int userInput;
        try {
            userInput = Integer.parseInt(userInterface.checkEndOrNot());
            if (userInput == 1) {
                return true;
            } else if (userInput == 2) {
                return false;
            } else {
                throw new IllegalArgumentException("올바르게 입력하세요.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return decideEndOrNot();
        }
    }
}
