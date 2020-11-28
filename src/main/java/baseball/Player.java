package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Player {
    final Scanner scanner;
    private char[] lastGuess = new char[Constants.ANSWER_LENGTH];
    
    public Player(final Scanner scanner) {
        this.scanner = scanner;
        Arrays.fill(lastGuess, ' ');
    }
    
    public void guessAnswer() {
        String playerGuessInput;
        
        System.out.print("숫자를 입력해 주세요 : ");
        playerGuessInput = this.scanner.nextLine().trim();
        try {
            refreshLastGuess(playerGuessInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
    
    private void refreshLastGuess(final String playerGuessInput) {
        try {
            checkValidGuessInput(playerGuessInput);
        } catch (IllegalArgumentException exception) {
            throw exception;
        }
        
        for (int i = 0; i < 3; i++) {
            this.lastGuess[i] = playerGuessInput.charAt(i);
        }
    }
    
    private void checkValidGuessInput(final String playerGuessInput) {
        try {
            checkValidLength(playerGuessInput, Constants.ANSWER_LENGTH);
            checkAllDigits(playerGuessInput);
            checkAllInRange(playerGuessInput, Constants.MIN_DIGIT, Constants.MAX_DIGIT);
            checkNotDuplicated(playerGuessInput);
        } catch (IllegalArgumentException exception) {
            throw exception;
        }
    }
    
    private void checkValidLength(final String playerInput, final int validLength) {
        if (playerInput.length() != validLength) {
            throw new IllegalArgumentException(validLength + "자리 수를 입력해 주세요.");
        }
    }
    
    private void checkAllDigits(final String playerInput) {
        for (int i = 0; i < playerInput.length(); i++) {
            if (!Character.isDigit(playerInput.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력해 주세요.");
            }
        }
    }
    
    private void checkAllInRange(final String playerInput,
            final int lowerBound, final int upperBound) {
        
        for (int i = 0; i < playerInput.length(); i++) {
            if (playerInput.charAt(i) - '0' < lowerBound || upperBound < playerInput.charAt(i) - '0') {
                throw new IllegalArgumentException("각 자리가 "
                        + lowerBound + " 이상 "
                        + upperBound + " 이하인 숫자만 입력해 주세요.");
            }
        }
    }
    
    private void checkNotDuplicated(final String playerInput) {
        HashSet<Character> duplicatedCheckSet = new HashSet<>();
        
        for (int i = 0; i < playerInput.length(); i++) {
            if (duplicatedCheckSet.contains(playerInput.charAt(i))) {
                throw new IllegalArgumentException("각 자리가 중복되지 않게 입력해 주세요.");
            }
            duplicatedCheckSet.add(playerInput.charAt(i));
        }
    }
}
