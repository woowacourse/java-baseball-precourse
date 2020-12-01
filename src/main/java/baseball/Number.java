package baseball;

/*
 *              Computer, User의 야구 숫자를 다루는 클래스
 * @author      483759/윤이진
 * */
public class Number {
    private int[] numArray;     //해당 객체의 자리별 숫자를 저장하는 배열
    private boolean[] isUsed;   //인덱스에 해당하는 숫자가 사용되었는지 체크하는 배열

    /* Number객체가 생성될 때 배열을 할당 및 초기화하는 메소드 */
    public Number(int size){
        numArray= new int[size];
        isUsed=new boolean[10];
        for(int i=0;i<10;i++)
            isUsed[i]=false;
    }

    /* index 번째 숫자를 number로 설정하는 메소드 */
    public void setNumberAt(int index, int number){
        this.numArray[index]=number;
        isUsed[number]=true;
    }

    /* index 위치의 숫자를 반환하는 메소드 */
    public int getNumberAt(int index){return this.numArray[index];}

    /* 특정 숫자가 사용되었는지 체크하는 메소드 */
    public boolean isUsedNumber(int number){
        return isUsed[number];
    }

    /* 해당 객체에 number값을 가진 원소의 위치를 반환하는 메서드 */
    public int findNumber(int number){
        for(int i=0;i<numArray.length;i++)
            if(numArray[i]==number){
                return i;
            }
        return -1;
    }
}
