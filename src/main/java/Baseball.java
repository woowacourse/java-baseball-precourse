import java.util.*;

public class Baseball {
    public static List<Integer> getNum3(){
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(arr);
        List<Integer> subList = arr.subList(0, 3);
        return subList;
    }
    public static List<Integer> get3(){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        List<Integer> thisList = new ArrayList<Integer>(Arrays.asList(num/100, num%100/10, num%10));
        return thisList;
    }

    public static int strikeNum(List<Integer> bN, List<Integer> yN){
        int strike = 0;
        if(bN.get(0)==yN.get(0)) strike++;
        if(bN.get(1)==yN.get(1)) strike++;
        if(bN.get(2)==yN.get(2)) strike++;
        return strike;
    }

    public static int ballNum(List<Integer> bN, List<Integer> yN){
        int ball = 0;
        if(bN.get(0)==yN.get(1)||bN.get(0)==yN.get(2)) ball++;
        if(bN.get(1)==yN.get(0)||bN.get(1)==yN.get(2)) ball++;
        if(bN.get(2)==yN.get(0)||bN.get(2)==yN.get(1)) ball++;
        return ball;
    }

    public static boolean tellAns(int s, int b){
        if(s==0&&b==0) System.out.println("낫싱");
        else if(b==0) System.out.printf("%d 스트라이크\n", s);
        else if(s==0) System.out.printf("%d 볼\n", b);
        else System.out.printf("%d 스트라이크 %d 볼\n", s, b);
        boolean isEnd = false;
        if(s==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isEnd = true;
        }
        return isEnd;
    }

    public static boolean toContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        boolean cont = true;
        if(num!=1) cont = false;
        return cont;
    }
    public static void main(String args[]){
        boolean cont = true;
        while(cont){
            List<Integer> baseballNum = getNum3();
            boolean end = false;
            while(!end) {
                List<Integer> yourNum = get3();
                int strike = strikeNum(baseballNum, yourNum);
                int ball = ballNum(baseballNum, yourNum);
                end = tellAns(strike, ball);
            }
            cont = toContinue();
        }
        return;
    }
}
