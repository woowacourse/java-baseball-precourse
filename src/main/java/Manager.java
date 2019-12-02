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

    /*
     게임 시작 및 해당 게임의 종료여부 판별
     */

<<<<<<< HEAD
    void start_game(){
        computer.generate_randomNumber();

        while(true){
            user.input_userNumber();

            if(!computer.count_strike_and_balls(
                    computer.get_checkBoard(),
                    computer.get_randomNumber(),
                    user.get_userNumber())){
=======
    void startGame(){
        computer.generateRandomNumber();

        while(true){
            user.inputUserNumber();

            if(!computer.countStrikeAndBalls(
                    computer.getCheckBoard(),
                    computer.getRandomNumber(),
                    user.getUserNumber())){
>>>>>>> master
                continue;
            }
            break;
        }
    }

    /*
     이전 게임 종료 후 프로그램의 종료여부 판별
     */

<<<<<<< HEAD
    void restart_or_end_game(){
=======
    void restartOrEndGame(){
>>>>>>> master
        String choice;

        while(true){
            System.out.println("게임을 새로 시작하려면 1, 종료려면 2를 입력하세요.");
            choice = scanner.nextLine();

            if(choice.equals("1")){
<<<<<<< HEAD
                start_game();
=======
                startGame();
>>>>>>> master
            }else if(choice.equals("2")){
                System.out.println("게임을 종료합니다.");
                break;
            }else{
                System.out.println("올바르지 않은 입력입니다. 다시 입력하세요.");
            }
        }
    }
}
