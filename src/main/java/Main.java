import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        int[] result;

        while (true) {
            System.out.println("숫자를 입력해주세요 :");
            user.input_numbers();
            result = computer.compare_number(user.get_user_numbers());
            print(result);

            int check = check_three_strike(result[0]);
            if (check == 1) {
                computer.number_generator();
                computer.print_computer_numbers();
            } else if (check == 2)
                break;
        }


    }

    public static void print(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("포 볼");
        } else {
            if (result[0] == 0) {
                System.out.println(result[1] + " 볼");
            } else if (result[1] == 0) {
                System.out.println(result[0] + " 스트라이크");
            } else {
                System.out.println(result[0] + " 스트라이크" + " " + result[1] + " 볼");
            }
        }
    }

    public static int check_three_strike(int strike) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            answer = sc.nextInt();

        }

        return answer;
    }
}
