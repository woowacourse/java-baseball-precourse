import java.util.Scanner;

public class Baseball {

    public void setInputNum(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        int userNum = sc.nextInt();
        setDivUserNum(userNum);
    }

    public void setDivUserNum(int num){
        int a = num/100, b = (num - (a*100))/10, c = num - ((a*100) + (b*10));
    }

}
