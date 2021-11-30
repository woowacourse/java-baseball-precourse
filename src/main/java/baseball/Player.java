package baseball;

public class Player extends Numbers{
    public int[] inputValue;

    public void setInputValue(int inputValue) {
    /*
        [definition]
        사용자로부터 입력 받은 값을 input value 에 업데이트 하는 함수입니다.
    */
        this.inputValue = convertNumberToArray(inputValue);
    }

    public boolean isValidNumber() {
        return super.isValidNumber(inputValue);
    }
}
