package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
    private ArrayList<Integer> userInput;

    public ArrayList<Integer> getUserInput() {
        return userInput;
    }

    // 값을 입력받아 이를 처리한 뒤 ArrayList에 저장하는 함수
    public void setInput(Scanner scanner) throws Throwable {
        String inputString = new String();

        System.out.println("숫자를 입력해주세요: ");
        userInput = new ArrayList<>();
        inputString = scanner.nextLine().trim();
        char [] input = inputString.toCharArray();
        if(inputString.length() != 3) {
            throw new IllegalArgumentException("숫자 입력 오류입니다. 다시 입력해주세요.");
        } else if(input[0] == input[1] || input[0] == input[2]
                || input[1] == input[2]) {
            throw new IllegalArgumentException("숫자 입력 오류입니다. 다시 입력해주세요.");
        }

        for(int i = 0; i < 3; i++) {
            userInput.add(Character.getNumericValue(input[i]));
            if(userInput.get(i) > 9 || userInput.get(i) < 1) {
                throw new IllegalArgumentException("숫자 입력 오류입니다. 다시 입력해주세요.");
            }
        }
        return;
    }
}
