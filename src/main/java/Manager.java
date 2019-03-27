import java.util.Scanner;

public class Manager {
    private Computer computer;
    private User user;
    private Scanner scanner;

    Manager(){
        computer = new Computer();
        user = new User();
        scanner = new Scanner(System.in);
    }

    /**
     * 컴퓨터와 사용자가 입력한 숫자들이 수와 자리까지 일치하면 true, 아니면 false 를 리턴한다.
     */
    boolean numbers_are_same(int[] computer_number, int[] my_number, boolean[] check_number){
        int strike_count = 0;
        int ball_count = 0;

        for(int i=0; i<3; i++){
            if(computer_number[i] == my_number[i]) {
                strike_count++;
            }else if(check_number[my_number[i]]) {
                ball_count++;
            }
        }

        if(strike_count > 0){
            System.out.print(strike_count);
            System.out.print(" 스트라이크 ");
        }

        if(ball_count > 0){
            System.out.print(ball_count);
            System.out.print(" 볼 ");
        }

        if(strike_count == 0 && ball_count == 0){
            System.out.print("낫싱");
        }

        System.out.println();

        if(strike_count == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    /**
     * 3자리의 0이 아니면서 중복되지 않는 숫자만 입력하였으면 true, 아니면 false를 리턴한다.
     */
    boolean check_right_number(String num){
        try{
            Integer.parseInt(num);
        }catch(NumberFormatException e){ // 숫자가 아닌 값이 있으면
            System.out.println(InputError.NUMBER_FORMAT_ERROR);
            return false;
        }

        if(num.length() != 3) { // 3자리의 숫자가 아니면
            System.out.println(InputError.LENGTH_ERROR);
            return false;
        }else if(num.indexOf("0") != -1){ // 0이 포함되어 있으면
            System.out.println(InputError.ZERO_NUMBER_ERROR);
            return false;
        }else if(num.charAt(0) == num.charAt(1) || num.charAt(0) == num.charAt(2) || num.charAt(1) == num.charAt(2)){ // 서로 중복되면
            System.out.println(InputError.DUPLICATE__NUMBER_ERROR);
            return false;
        }

        return true;
    }

    /**
     * 게임을 시작한다.
     */
    void start_game() {
        computer.make_number();
        computer.make_check_number();
        String num;

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            num = scanner.next();

            if(!check_right_number(num)){
                continue;
            }

            user.input_number(Integer.parseInt(num));

            if(numbers_are_same(computer.get_number(), user.get_number(), computer.get_check_number())) { // 결과를 리턴하며 3 스트라이크면 종료한다.
                break;
            }
        }
    }

    /**
     * 게임을 새로 시작하거나 종료한다.
     */
    void start_or_end() {
        while(true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String cmd = scanner.next();

            if(cmd.compareTo("1") != 0 && cmd.compareTo("2") != 0){
                System.out.println(InputError.OTHER_NUMBER_ERROR);
                continue;
            }

            if(cmd.compareTo("1") == 0){
                start_game();
            }else{
                break;
            }
        }
        System.out.print("게임을 완전히 종료합니다.");
    }
}
