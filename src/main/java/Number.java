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

    /*세자리 숫자의 값들 가진 객체를 return 함*/
    public Number getNumber(){
        return this;
    }
    /*
     * @return 객체 자체를 반환 (세수를 모두 반환하기 위해)
     */

    /*세자리 숫자의 값을 지정함*/
    public void setNumber(int first,int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
    /*
     * @param 세팅할 세 개의 숫자를 각각 매개변수로 받음
     */
}
