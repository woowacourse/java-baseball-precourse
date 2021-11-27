package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {

        // 기능 1: 랜덤 값 생성
        String targetNumber = randomNumber();
        String result = "";
        while(true){
            boolean restartFlag = false;
            String restartOrder = "";

            //  기능 2: 사용자로부터 값 입력받기
            System.out.print("숫자를 입력해주세요: ");
            String inputNumber = Console.readLine();

            //  기능 4: 사용자 입력에 대한 예외처리
            inputException(inputNumber);

            //  기능 3: 사용자 입력값과 상대(컴퓨터)값 비교
            result = validation(inputNumber, targetNumber);
            System.out.println(result);

            //  기능 5: 게임 재시작 또는 종료
            if(result.equals("3스트라이크")){
                restartOrder = restartOrStop();
                restartFlag = true;
            }
            if(restartFlag && restartOrder.equals("stop")){
                break;
            }
        }
    }
    public static String randomNumber(){
        String firstNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
        String secondNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
        String thirdNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
        return firstNumber + secondNumber + thirdNumber;
    }

    public static String validation(String number, String target){
        String resultMessage = "";
        int strikeCount = 0;
        int ballCount = 0;
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) == target.charAt(i)){
                strikeCount++;
            } else if (target.contains(String.valueOf(number.charAt(i)))){
                ballCount++;
            }
        }
        if(strikeCount == 0 && ballCount == 0){
            resultMessage = "낫싱";
        } else {
            if (ballCount != 0) {
                resultMessage += ballCount + "볼 ";
            }
            if (strikeCount != 0){
                resultMessage += strikeCount + "스트라이크";
            }
        }

        return resultMessage;
    }

    public static void inputException(String number){
        String regExp = "^[0-9]+$";
        if(!number.matches(regExp)){
            throw new IllegalArgumentException();
        }
    }

    public static String restartOrStop(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String value = Console.readLine();

        if(value.equals("2")){
            return "stop";
        }
        return "restart";
    }
}
