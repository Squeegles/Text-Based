/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {

        // Build rooms
        final int WIDTH = 15;
        final int HEIGHT = 15;
        Room[][] room = new Room[WIDTH][HEIGHT];
        Rooms.build(room, WIDTH, HEIGHT);
        int x = 0;
        int y = 7;
        int score = 0;

        // Load inventory
        ArrayList<String> inventory = new ArrayList<>();
        
        // Title Screen
    	System.out.println("+-------------------------------+");
    	System.out.println("| Text Adventure: Skeleton Code |");
    	System.out.println("+-------------------------------+");
    	
    	Sounds.playTitleMusic(1);
    	
    	// Print starting room description
    	Rooms.print(room, x, y);

        // Start game loop
        boolean playing = true;
        while (playing) {

        	// Get user input
            String input = Input.getInput();

            // Movement commands
            if (input.equals("n")) {
                if (x < HEIGHT - 1 && room[x][y].exits.contains("n")) {
                    x++;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("s")) {
                if (x > 0 && room[x][y].exits.contains("s")) {
                    x--;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("e")) {
                if (y < WIDTH - 1 && room[x][y].exits.contains("e")) {
                    y++;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("w")) {
                if (y > 0 && room[x][y].exits.contains("w")) {
                    y--;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            }

            // Look commands
            else if (input.equals("look")) {
                Rooms.print(room, x, y);
            }
            
            

            // Get commands
            else if (input.length() > 4  && input.substring(0, 4).equals("get ")) {
            	if (input.substring(0, input.indexOf(' ')).equals("get")) {
            		if (input.substring(input.indexOf(' ')).length() > 1) {
            			String item = input.substring(input.indexOf(' ') + 1);
                    	score = Inventory.checkItem(x, y, item, inventory, room, score);
            		}	
            	}
            }

            // Inventory commands
            else if (input.equals("i") || input.equals("inv")
                    || input.equals("inventory")) {
                Inventory.print(inventory);
            }
            
            else if (input.equals("score")) {
            	System.out.println("Score: " + score + "/500");
            }
            
            else if (input.equals("restart")) {
            	System.out.println();
            	Main.main(args);
            }
            
            else if (input.equals("help")) {
                System.out.println("These are the command you can type at the > prompt:");
            	System.out.println(" 'n'/'e'/'s'/'w' to move");
            	System.out.println(" 'look' for a description of the room you're in");
            	System.out.println(" 'get' + the item to get something");
            	System.out.println(" 'i' to view your inventory");
            	System.out.println(" 'score' to view your score");
            	System.out.println(" 'restart' to restart the game");
            	System.out.println(" 'quit' to quit the game");
            }
            
            // Quit commands
            else if (input.equals("quit")) {
                System.out.println("Goodbye!");
                playing = false;

            // Catch-all for invalid input
            } else {
                System.out.println("You can't do that.");
            }
        }
        System.exit(0);
    }
}

