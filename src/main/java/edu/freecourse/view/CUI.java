package edu.freecourse.view;

import edu.freecourse.tool.Computer;

public class CUI {

    public static void main(String[] args){

        Computer computer = new Computer();
        computer.newGame();

        for(int i : computer.getNumbers()){
            System.out.println(i);
        }

    }

}
