package baseball;

import java.util.HashSet;
import java.util.Scanner;

public class Player {
    private final Scanner scanner;
    private Game game;
    private char[] lastGuess = new char[Constants.ANSWER_LENGTH];
    private boolean playing;
    private boolean guessSuccess;
    
    public Player(final Scanner scanner, Game game) {
        this.scanner = scanner;
        this.game = game;
        this.playing = true;
        this.guessSuccess = false;
    }
    
    public boolean isPlaying() {
        return this.playing;
    }
    
    public boolean isGuessSuccess() {
        return this.guessSuccess;
    }
    
    public void guessAnswer() {
        String playerGuessInput;
        BallCount ballCount;
        
        System.out.print("숫자를 입력해 주세요 : ");
        playerGuessInput = this.scanner.nextLine().trim();
        try {
            refreshLastGuess(playerGuessInput);
            ballCount = game.judge(this.lastGuess);
            ballCount.printCount();
            refreshGuessSuccess(ballCount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
    
    public void printSuccess() {
        System.out.println(Constants.ANSWER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    
    public void askContinue() {
        String playerContinueInput;
        
        System.out.println("게임을 새로 시작하려면 " + Constants.CONTINUE + ", 종료하려면 "
                + Constants.STOP + "를 입력하세요.");
        
        while (true) {
            playerContinueInput = this.scanner.nextLine().trim();
            try {
                refreshPlaying(playerContinueInput);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
    
    private void refreshLastGuess(final String playerGuessInput) {
        try {
            checkValidGuessInput(playerGuessInput);
        } catch (IllegalArgumentException exception) {
            throw exception;
        }
        
        for (int i = 0; i < Constants.ANSWER_LENGTH; i++) {
            this.lastGuess[i] = playerGuessInput.charAt(i);
        }
    }
    
    private void refreshPlaying(final String playerContinueInput) {
        int continueInputParsed;
        
        try {
            checkValidContinueInput(playerContinueInput);
            
        } catch (IllegalArgumentException exception) {
            throw exception;
        }
        
        continueInputParsed = Integer.parseInt(playerContinueInput);
        
        if (continueInputParsed == Constants.CONTINUE) {
            this.playing = true;
            this.guessSuccess = false;
        } else if (continueInputParsed == Constants.STOP) {
            this.playing = false;
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
    
    private void checkValidContinueInput(final String playerGuessInput) {
        try {
            checkValidLength(playerGuessInput, 1);
            checkAllDigits(playerGuessInput);
            checkAllInRange(playerGuessInput, Constants.CONTINUE, Constants.STOP);
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
    
    private void refreshGuessSuccess(BallCount ballCount) {
        if (ballCount.getStrike() == Constants.ANSWER_LENGTH) {
            this.guessSuccess = true;
        }
    }
}
