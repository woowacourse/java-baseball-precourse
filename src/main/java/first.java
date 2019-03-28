import java.util.Random;
import java.util.Scanner;

public class first{

    public static void main(String[] arg)
    {
        int user[];
        int com[];
        int cnt = 0;
        int endn = 0;
        Scanner sc = new Scanner(System.in);
        while(endn == 2){
            System.out.println("숫자를 입력해주세요 : ");
            int usr = sc.nextInt();
            user = usrinit(usr);
            com = cominit();

            if(cnt == 3)
            {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요\n");
                endn = sc.nextInt();
            }
        }
        
    }
    public static int[] cominit()
    {
        Random random = new Random();
        int cnum[] = new int[3];
        while(true)
        {
            cnum[0] = random.nextInt(10);
            cnum[1] = random.nextInt(10);
            cnum[2] = random.nextInt(10);
            if((cnum[0]!=cnum[1]) && (cnum[0]!=cnum[2])&& (cnum[1]!=cnum[2]))
            {
                break;
            }
        }

        return cnum;
    }
    public static int[] usrinit(int user)
    {
        int num[] = new int[3];
        
        num[0] = user/100;
        num[1] = user%100/10;
        num[2] = user%10;

        return num;
    }
    public static int game(int[] usr, int[] com)
    {
        int cnt = 0;
        int bll = 0;
        for(int i = 0; i<3; i++)
        {
            if(usr[i] == com[i])    //같은 자리 -> 스트라이크
            {
                cnt++;
            }
            else if(usr[i] == com[(i+1)%3]) //다른 자리에 있을 때(usr[2]이면 com[0] 판단)
            {
                bll++;
            }
            else if(usr[i] == com[(i+2)%3])//다른 자리에 있을 때
            {
                bll++;
            }
        }
        if(cnt==0 && bll==0)
        {
            System.out.println("낫싱");
        }
        else
        {
            if(cnt!=0)
            {
                System.out.println(cnt + " 스트라이크 ");
            }
            if(bll!=0)
            {
                System.out.println(bll+"볼");
            }
        }
        return cnt;
    }
}