/*
 * 클래스 이름 : BaseBall
 *
 * 버전 정보 : 1.0
 *
 * 날짜 : 2019.12.3
 *
 * 저작권 주의 : https://github.com/takhyeongmin
 */

package domain;

public class BaseBall {

    private NumberCard numberCard;

    public BaseBall(NumberCard numberCard) {
        this.numberCard = numberCard;
    }

    public NumberCard getNumberCard() {
        return numberCard;
    }

    @Override
    public boolean equals(Object obj) {
        BaseBall otherBaseBall = (BaseBall) obj;

        if (otherBaseBall.numberCard == this.numberCard) {
            return true;
        }
        if (otherBaseBall.numberCard != this.numberCard) {
            return false;
        }
        throw new IllegalArgumentException("BaseBall 타입이 아닙니다.");
    }

}
