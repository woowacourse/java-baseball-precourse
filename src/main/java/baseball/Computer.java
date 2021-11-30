package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	private ArrayList<Integer> computerNum;

	private void initComputerNum() {
		computerNum = new ArrayList<Integer>();
	}

	protected void generateComputerRandomNum() {
		initComputerNum();
		while(computerNum.size() < 3) {
			int tempNum = Randoms.pickNumberInRange(1, 9);
			if(!checkUniqueNum(tempNum)) {
				computerNum.add(tempNum);
			}
		}
		System.out.println(computerNum);
	}

	private boolean checkUniqueNum(int tempNum) {
		return computerNum.contains(tempNum);
	}

	protected ArrayList<Integer> getComputermNum() {
		return computerNum;
	}
}
