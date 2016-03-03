/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Scanner;

public class Input {
	
    public static String getInput() {
    	
        System.out.print("> ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        
        return input.toLowerCase();
    }
}

