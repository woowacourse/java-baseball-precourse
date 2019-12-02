public class InputVerification {
	
	boolean isUnique = true;
	Printer printer = new Printer();
	
	public boolean checkData(int p, String player){
		if(checkNum(player) && checkNumCnt(player)
				&& checkZeroNum(player) && checkDupNum(player)) {
			return true;	
		} else if(p == 2){
			printer.printMessage(1);
			return false;
		} else {
			return false;
		}
    }
	
	private boolean checkDupNum(String player){ // 숫자 중복 체크 메소드
    	if(player.charAt(0) != player.charAt(1) 
    			&& player.charAt(1) != player.charAt(2)
    			&& player.charAt(0) != player.charAt(2)) {
    		return true;
    	} else {
    		return false;
    	}
    }
	
	private boolean checkNum(String player){ //숫자로만 이뤄졌는지 검증하는 메소드
    	try {
    		Integer.parseInt(player);
    		return true;
    	} catch(NumberFormatException e) {
    		return false;
    	}
    }

    private boolean checkNumCnt(String player){ //3자리 수가 맞는지 검증하는 메소드
        if(player.length() == 3){
            return true;
        } 
        return false;
    }

    private boolean checkZeroNum(String player) { //0이 있는지 검증하는 메소드
    	if(player.contains("0")) {
    		return false;
    	}
    	return true;
    }
}
