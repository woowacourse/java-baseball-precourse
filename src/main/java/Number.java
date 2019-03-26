/*
 *@(#)Number.java           1.1 2019/03/26
 *Copyright (c) 2019 Hyogeon Kim.
 *Number Baseball Game, Java, Mungyeong, KOREA
 */

/*
 * 야구게임에서 세개의 숫자에 대한 클래스
 * @version               1.1 2019년 03월 26일
 * @author                김효건
 */
public class Number {
    /*세자리 숫자 세팅, 반환 구현*/

    /*세개의 숫자 중 첫번째 숫자를 나타내는 변수*/
    private int first;

    /*세개의 숫자 중 두번째 숫자를 나타내는 변수*/
    private int second;

    /*세개의 숫자 중 세번째 숫자를 나타내는 변수*/
    private int third;

    /*세개의 숫자 세팅하는 생성자*/
    public Number(int first,int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /*첫번째 숫자를 반환*/
    public int getFirst(){
        return this.first;
    }
    /*
     * @return 첫번째 숫자 반환
     */

    /*두번째 숫자를 반환*/
    public int getSecond(){
        return this.second;
    }
    /*
     * @return 두번째 숫자 반환
     */

    /*세번째 숫자를 반환*/
    public int getThird(){
        return this.third;
    }
    /*
     * @return 세번째 숫자 반환
     */

    /*첫번째 숫자를 세팅*/
    public void setFirst(){
        this.first = first;
    }
    /*
     * @param 첫번째 숫자 세팅
     */

    /*두번째 숫자를 세팅*/
    public void setSecond(){
        this.second = second;
    }
    /*
     * @param 두번째 숫자 세팅
     */

    /*세번째 숫자를 세팅*/
    public void setThird(){
        this.third = third;
    }
    /*
     * @param 세번째 숫자 세팅
     */
}
