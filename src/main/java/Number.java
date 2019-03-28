/*
 *  Number.java
 *
 *  ver 1.0.2
 *
 *  2019/03/28
 *
 */

/*
 *  Number 클래스
 *  숫자야구
 *
 */
public class Number {
    // 숫자 3개를 가지는 배열
    protected int[] number = new int[3];

    /*
     * setNum 메서드
     * 전달인자 : 없음
     * 난수를 발생 시켜 인스턴스 변수에 할당하는 메서드
     */
    public void setNumber(){
        for (int i = 0; i < 3; ++i) {
            this.number[i] = (int) (Math.random() * 10);
            if (this.isOverlap(i)) i--;
        }
    }

    /*
     * isOverlap 메서드
     * 전달인자 : 난수 발생을 통해 얻은 배열의 현재 인덱스
     * 이전의 난수값과 현재 발생된 난수값을 비교하여 중복이 되지 않게 해주는 메서드
     */
    public boolean isOverlap(int i){
        boolean isExist = false;

        for (int k = 0; k < i; ++k){
            if (this.number[i] == this.number[k]){
                isExist = true;
                break;
            }
        }
        return isExist;
    }
}
