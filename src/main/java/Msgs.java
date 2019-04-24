
/**
 * 메시지 상수를 보관하는 Enum 클래스
 * 
 * @author wschoi8640
 * @version 1.1
 */
public enum Msgs {
	
	Ball("볼"),
	Strike("스트라이크"),
	ThreeStrike("3개 모두 맞히셨습니다."),
	MyNumReceive("세자리 수를 입력하세요."),
	GameModeReceive("계속하려면 1, 그만하려면 2를 입력하세요."),
	InputWrongErr("올바르지 않은 입력입니다."),
	InputTypeErr("자연수 세자리를 입력해야 합니다.");
	
	String msg = "";
	Msgs(String msg){
		this.msg = msg;
	}
	
	String getMsg(){
		return msg; 
	}
}
