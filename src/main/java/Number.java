/*
 *  Number.java
 *
 *  ver 1.0.0
 *
 *  2019/03/25
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
