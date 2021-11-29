package baseball;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        //TODO: 숫자 야구 게임 구현

//        Printer printer = new Printer();
        while (true) {

            List<Integer> computerDeck = new ArrayList<>();

            int count = 0;
            while (count < 3) {

                Integer num = Randoms.pickNumberInRange(1, 9);
                if (computerDeck.contains(num)) {
                    continue;
                }
                computerDeck.add(num);
                count++;
            }
            System.out.println(computerDeck);

            while (true) {

                Printer.requireNumberFromPlayer();
                String[] inputFromUser = Console.readLine().split("");

                List<Integer> playerExpectDeck = new ArrayList<>();
                try {
                    checkSize(inputFromUser);
                    for (int i = 0; i < 3; i++) {
                        Integer num = 0;
                        try {

                            num = Integer.parseInt(inputFromUser[i]);
                        } catch (NumberFormatException e) {

                            throw new IllegalArgumentException("문자를 입력하였습니다.");
                        }
                        if (num.equals(0)) {

                            throw new IllegalArgumentException("0을 입력하였습니다.");
                        }
                        if (playerExpectDeck.contains(num)) {

                            Printer.inputAlreadyExistNumber();
                            throw new IllegalArgumentException("중복된 수를 입력하였습니다.");
                        }
                        playerExpectDeck.add(num);
                    }
                } catch (IllegalArgumentException e) {

                    System.out.println(e.getMessage());
                    System.exit(0);
                }

                Integer strike = 0;
                Integer ball = 0;

                for (int i = 0; i < 3; i++) {
                    Integer num = playerExpectDeck.get(i);
                    if (num.equals(computerDeck.get(i))) {
                        strike++;
                        continue;
                    }
                    if (computerDeck.contains(num)) {
                        ball++;
                    }
                }
                StringBuilder printResult = new StringBuilder();
                if (!ball.equals(0)) {

                    printResult.append(ball).append("볼 ");
                }
                if (!strike.equals(0)) {
                    printResult.append(strike).append("스트라이크");
                }

                if (printResult.length() == 0) {
                    printResult.append("낫싱");
                }
                System.out.println(printResult);

                if (strike.equals(3)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            Integer reGame = Integer.parseInt(Console.readLine());
            if (reGame.equals(2)) {
                break;
            }
        }
    }

    private static void checkSize(String[] inputFromUser) {
        if (inputFromUser.length != 3) {

            throw new IllegalArgumentException("세 개의 수를 입력해야 합니다.");
        }
    }
}
