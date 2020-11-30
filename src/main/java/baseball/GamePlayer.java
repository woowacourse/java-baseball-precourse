package baseball;
/*
 * GamePlayer
 *
 * version 1.0
 *
 * 2020.11.30
 *
 * Copyright (c) by Davinci.J
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GamePlayer {
    private static final char FIRST_BOUNDARY_VALUE = '1';
    private static final char LAST_BOUNDARY_VALUE = '9';
    private static final int COUNT_LIMIT = 3;
    private static final int GAME_RESTART = 1;
    private static final int GAME_END = 2;
    private static final String RE_ENTER = "다시 입력해주세요";

    private Scanner scanner;

    public GamePlayer(Scanner scanner){
        this.scanner = scanner;
    }

    public String generateNumbersOfPlayerEntered()
                                            throws IllegalArgumentException {
        String generatedNumbers = scanner.next();

        if(generatedNumbers.length() != COUNT_LIMIT){
            throw new IllegalArgumentException(RE_ENTER);
        }

        if(isNotAllNumbers(generatedNumbers)){
            throw new IllegalArgumentException(RE_ENTER);
        }

        if(haveDuplicateNumbers(generatedNumbers)){
            throw new IllegalArgumentException(RE_ENTER);
        }

        return generatedNumbers;
    }

    private boolean isNotAllNumbers(String generatedNumbers) {
        for(int i=0; i<generatedNumbers.length(); i++){
            if(generatedNumbers.charAt(i) < FIRST_BOUNDARY_VALUE
                    || generatedNumbers.charAt(i) > LAST_BOUNDARY_VALUE) {
                return true;
            }
        }
        return false;
    }

    private boolean haveDuplicateNumbers(String generatedNumbers) {
        Set<Character> numbers = new HashSet<>();

        for (int i=0; i<generatedNumbers.length(); i++) {
            numbers.add(generatedNumbers.charAt(i));
        }

        return numbers.size() != COUNT_LIMIT;
    }

    public int selectRestartOrEnd() {
        String selectedMode = scanner.next();

        while (isInvalidMode(selectedMode)) {
            System.out.println(RE_ENTER);
            selectedMode = scanner.next();
        }

        return selectedMode.charAt(0) - '0';
    }

    private boolean isInvalidMode(String selectedMode) {
        int firstDigitOfSelectedMode = selectedMode.charAt(0) - '0';

        return selectedMode.length() != 1
                || (firstDigitOfSelectedMode != GAME_RESTART && firstDigitOfSelectedMode != GAME_END);
    }

}
