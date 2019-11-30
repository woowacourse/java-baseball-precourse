/*
 * Main class
 * 
 * version?
 * 
 * 2019-11-30
 * 
 * patent?
 */

package domain;

public class Main {
	public static void main(String args[]) {
		User me = new User();
		Computer myComputer = new Computer();
		
		myComputer.generateNumbers();
		myComputer.printNumbers();
		me.enterNumber();
		System.out.println(me.getNumbers()[0]);
		System.out.println(me.getNumbers()[1]);
		System.out.println(me.getNumbers()[2]);
		myComputer.printGameResult(me.getNumbers());
	}
}
