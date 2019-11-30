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
		
		me.enterNumber();
		myComputer.generateNumbers();
		myComputer.printNumbers();
	}
}
