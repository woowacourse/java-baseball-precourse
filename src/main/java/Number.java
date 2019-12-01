import java.util.Random;

/**
 * Number
 */
public class Number {
    private final int[] digits = new int[9];
    public int len;
    private String num="";

    //1~9까지를 받아들이는 배열을 만들고 골라진 숫자를 1,2,3... 을 매김.
    //가령 713이라는 숫자는 digits[6]==1, digits[0]==2, digits[2]==3
    //for 문 두개 돌리는 것 보다는 자료구조를 더 활용하여 3자리 이상도 대비(뒤의 while문은 확률적으로 거의 안 들어감)
    public Number(int _len) {
        len = _len;
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int rand_int = rand.nextInt(9);
            while(digits[rand_int]!=0){
                rand_int = (rand_int+1)%9;
            }
            digits[rand_int] = i+1;
        }       
    }

    //encapsulation + return true number
    public int[] getDigits(){
        int[] number = new int[len];
        for(int k=0; k<digits.length; k++){
            if(digits[k]!=0){
                number[digits[k]-1]=k+1;
            }
        }
        return number;
    }

    //String으로 디버깅용
    private String showDigits() {
        int[] temp = new int[len];
        for(int j=0; j<digits.length; j++){
          if(digits[j]!=0){
            temp[digits[j]-1]=j+1;
          }
        }
        for(int digit : temp){
            num = num + String.valueOf(digit);
        }
        return num;
    }
}