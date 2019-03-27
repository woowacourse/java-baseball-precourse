import java.util.Scanner;


public class User {
    static Scanner sc;
    static int Usernumber[];

    /*
     *  사용자 숫자 입력받는다
     */
    public void setUserNumber() {
        sc = new Scanner(System.in);
        Usernumber = new int[3];
        System.out.print("숫자를 입력해주세요 : ");
        String number =sc.next();
        for(int i =0; i<3; i++) {
            Usernumber[i] = number.charAt(i)-48;
        }
    }

    /*
     *  사용자 숫자 get
     */
    public int[] getUserNumber() {
        return Usernumber;
    }

    /*
     *  게임 재시작 , 종료
     */
    public int setendGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int command = sc.nextInt();
        return command;
    }

}