/*
 * @(#)PlayerInput.java
 *
 * v 0.0.0
 *
 * 2019.11.28
 *
 * Copyright 2019. DunDung all rights reserved.
 */

import java.util.Scanner;

public class PlayerInput {
    private static Scanner scan = new Scanner(System.in);

    public static String inputNumber(){
        return scan.next().trim();
    }

}
