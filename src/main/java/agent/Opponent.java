package agent;

public class Opponent {
    private String answer;


    public boolean validate(String userInput) {
        int strike = 0;
        int ball = 0;
        char[] userInputToCharArray = userInput.toCharArray();
        for (int i = 0; i < userInput.length(); i++) {
            if(isStrike(userInput, i)) {
                strike++;
            } else if(isBall(userInput, i)) {
                ball++;
            }
        }

        printResult(strike, ball);

        return strike == 3;
    }

    private boolean isStrike(String userInput, int pos) {
        return userInput.charAt(pos) == answer.charAt(pos);
    }

    private boolean isBall(String userInput, int pos) {
        return !isStrike(userInput, pos) && answer.indexOf(userInput.charAt(pos)) != -1;
    }

    private void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else if (ball == 0) {
            System.out.printf("%d 스트라이크\n", strike);
        } else {
            System.out.printf("%d 스트라이크 %d볼\n", strike, ball);
        }
    }

    public String getAnswer() {
        return answer;
    }

    public void generateAnswer() {
        String result = "";
        while(result.length() < 3) {
            String candidate = generateAnswerCharacter();
            if (!result.contains(candidate)) {
                result += candidate;
            }
        }
        answer = result;
    }

    private String generateAnswerCharacter() {
        int rand = (int) Math.ceil(Math.random()*9);
        return String.valueOf(rand);
    }
}
