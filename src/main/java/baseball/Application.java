package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    static class Game{
        private static final int GAME_COUNT = 3;

        int[] computer_num = new int[GAME_COUNT];
        int[] user_num = new int[GAME_COUNT];
        int strike, ball, computer_size;

        /**
         * 숫자 야구 게임을 관리하는 Game class의 Constructor
         * 게임을 시작하고, 사용자가 새로운 게임을 시작할지 여부를 확인한다.
         */
        public Game(){
            System.out.println("숫자 야구 게임을 시작합니다.");
            do{
                play();
            } while(restart());
        }

        /**
         * 숫자 야구 게임을 시작하는 메소드이다.
         * 컴퓨터의 숫자를 생성하고, 사용자 입력을 받아 게임을 진행한다.
         */
        private void play(){
            computer_size = 0;
            setComputerNum();

            while(true){
                userInput();
                checkNum();
                if(strike == 3)
                    break;
            }
        }

        /**
         * computerNumSet메소드를 돕기 위한 메소드이다.
         * 해당 메소드는 computer_num에 중복되는 숫자가 있는지 확인한다.
         *
         * @return true 중복되는 수 존재함 - false 중복되는 수가 존재하지 않음
         */
        private boolean checkComputerNum(int check_num){
            for(int i = 0; i < computer_size; ++i)
                if(check_num == computer_num[i])
                    return true;

            return false;
        }

        /**
         * 컴퓨터의 숫자를 생성하고 중복을 피하기 위해 확인하는 메소드
         */
        private void setComputerNum(){
            for(; computer_size < GAME_COUNT; computer_size++){
                computer_num[computer_size] = Randoms.pickNumberInRange(1, 9);
                if(checkComputerNum(computer_num[computer_size]))
                    computer_size--;
            }
        }

        /**
         * 사용자로부터 입력을 받아 유효성을 검사하고,
         * user_num 배열에 저장하는 메소드
         *
         * @exception IllegalArgumentException 세 자리 숫자가 아니거나 1부터 9 사이의 숫자가 아닌 경우 발생
         */
        private void userInput(){
            System.out.print("숫자를 입력해주세요 : ");
            String temp = Console.readLine();
            char check;
            if(temp.length() != GAME_COUNT)
                throw new IllegalArgumentException("세 자리 숫자를 입력해야 합니다");

            for (int i = 0; i < GAME_COUNT; ++i){
                check = temp.charAt(i);
                if(check < '1' || check > '9')
                    throw new IllegalArgumentException("1부터 9 사이의 숫자를 입력해야 합니다.");
                user_num[i] = Character.getNumericValue(check);
            }

        }

        /**
         * strike와 ball의 결과를 출력하는 메소드
         */
        private void postResult(){
            if(ball != 0 && strike != 0)
                System.out.println(ball + "볼 " + strike + "스트라이크");
            else if(ball != 0 && strike == 0)
                System.out.println(ball + "볼");
            else if(ball == 0 && strike != 0)
                System.out.println(strike + "스트라이크");
            else
                System.out.println("낫싱");
        }

        /**
         * 사용자가 입력한 숫자와 컴퓨터의 숫자를 비교하여
         * strike와 ball값을 계산하는 메소드
         *
         * @param check_num 확인할 숫자
         * @param loc       숫자의 위치
         */
        private void checkUserInput(int check_num, int loc){
            for (int i = 0; i < GAME_COUNT; ++i) {
                if (check_num == computer_num[i] && loc == i)
                    strike++;
                else if (check_num == computer_num[i])
                    ball++;
            }
        }

        /**
         * 사용자가 입력한 수를 컴퓨터의 수와 비교하여
         * strike와 ball값을 확인하고, 결과를 출력한다.
         */
        private void checkNum() {
            strike = 0;
            ball = 0;

            for(int i = 0; i < GAME_COUNT; ++i)
                checkUserInput(user_num[i], i);

            postResult();
        }

        /**
         * 게임이 종료된 후 사용자에게 새로운 게임을 시작할지, 종료할지를 물어보고
         * '1'이면 새 게임을 실행하고, '2'이면 종료한다.
         *
         * @return True 새 게임 시작, False 게임 종료
         * @exception IllegalArgumentException - '1', '2'가 아닌 입력이 들어온 경우 발생
         */
        private boolean restart(){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String request = Console.readLine();

            if(!request.equals("1") && !request.equals("2"))
                throw new IllegalArgumentException();

            if(request.equals("1"))
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}