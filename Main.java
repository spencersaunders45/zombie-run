import java.util.*;

import Player.Player;
import Zombie.Zombie;
import maps.Maps;

public class Main {
   public static void main(String[] args){
      // Create Variables
      Scanner input = new Scanner(System.in);
      Player user = new Player();
      int round = 1;
      boolean gameActive = false;

      // Home screen
      String mainInput = welcome(input);
      if(mainInput.equals("h")){
         mainInput = displayInstructions(input);
      }

      if(mainInput.equals("p")){
         gameActive = true;

         // Pick the map
         Maps game = null;
         mainInput = mapSelection(input);
         if (mainInput.equals("field")){
            game = field();
         } else if(mainInput.equals("city")){
            // game = city();
         } else if(mainInput.equals("highway")){
            // game = highway();
         } else {
            System.out.println("Error: No map selected");
            return;
         }

         // Game loop
         while(gameActive == true){
            boolean nextLevel = false;
            int moveCount = 0;
            int shootCount = 0;
            while(moveCount < 3 && shootCount < 3){
               displayHud(game);
               game.displayMap();
               mainInput = action(input);

               // Ends the game
               if(mainInput.equals("q")){
                  gameActive = false;
                  break;

               // Moves the player
               } else if (mainInput.equals("w") || mainInput.equals("s") || mainInput.equals("a") || mainInput.equals("d")){
                  if (moveCount < 3){
                     boolean isValid = true;
                     do{
                        if (isValid == false){
                           System.out.println("Cannot move there: try again");
                           mainInput = action(input);
                        }
                        isValid = game.movePlayer(mainInput);
                     }while (isValid == false);
                     moveCount++;
                  } else {
                     System.out.println("Out of movement.");
                  }

               // Shoots zombies
               } else if (mainInput.equals("f")){
                  if(shootCount < 3){
                     game.shootZombie();
                     shootCount++;
                  } else {
                     System.out.println("No more shots this turn");
                  }

               // Error
               } else {
                  System.out.println("Error: Unknown input");
                  return;
               }
               nextLevel = game.checkZombies();
               if (nextLevel){
                  break;
               }
            }
            // Zombies turn
            if (nextLevel){
               continue;
            }
            game.moveZombie();
            game.attackPlayer();
            // Checks for player death
            if (game.getPlayer1().getHealth() <= 0){
               System.out.print("\n\n\n\n\n\n\n");
               System.out.println("Game Over\n\n");
               gameActive = false;
               break;
            }
            moveCount = 0;
            shootCount = 0;
         }
      }
      System.out.println("Thanks for playing!");
      input.close();
   }

   public static void displayHud(Maps game){
      Player player = game.getPlayer1();
      System.out.print("\n\n\n\n");
      System.out.println("Health: " + player.getHealth());
      System.out.println("Gun: " + player.getWeaponName());
      System.out.print("\n\n");
   }

   public static String welcome(Scanner input){
      System.out.print("\n\n\n\n\n\n");
      System.out.println("-------------Zombie Run-------------\n");
      System.out.println("          O      O         -O");
      System.out.println("          |--    |--      -/V");
      System.out.println("          |\\     |\\      -//");
      System.out.print("\n\n");
      System.out.println("How to play <h>");
      System.out.println("Play Zombie Run <p>");
      System.out.println("Exit Game <e>");
      String strInput;
      do{
         System.out.print("> ");
         strInput = input.nextLine();
      }while(!strInput.equals("h") && !strInput.equals("p") && !strInput.equals("e"));
      return strInput;
   }

   public static String displayInstructions(Scanner input){
      System.out.print("\n\n");
      System.out.println("The goal is to survive 10 waves of zombies. You will find ammo(*) and\nhealth packs(+) around the map each level. Walk over them to pick\nthem up. Each turn you can move twice and attack three times.\n");
      System.out.println("Play Zombie.Zombie Rub <p>");
      System.out.println("Exit Game <e>");
      System.out.println();
      String strInput;
      do{
         System.out.print("> ");
         strInput = input.nextLine().toLowerCase();
      }while(!strInput.equals("p") && !strInput.equals("e"));
      System.out.print("\n\n");
      return strInput;
   }

   public static String mapSelection(Scanner input){
      System.out.print("\n\n");
      System.out.println("Type the map to play on.");
      System.out.println("FIELD, CITY, HIGHWAY");
      String strInput;
      do{
         System.out.print("> ");
         strInput = input.nextLine().toLowerCase();
      } while(!strInput.equals("field") && !strInput.equals("city") && !strInput.equals("highway"));
      System.out.print("\n\n");
      return strInput;
   }

   public static String action(Scanner input){
      System.out.println();
      System.out.println("quit game<q>");
      System.out.println("up<w> down<s> left<a> right<d> shoot<f>");
      String strInput;
      do{
         System.out.print("> ");
         strInput = input.nextLine();
         if(!strInput.equals("w") && !strInput.equals("a") && !strInput.equals("s") && !strInput.equals("d")
                 && !strInput.equals("q") && !strInput.equals("c") && !strInput.equals("f")){
            System.out.println("Input not valid: try again");
         }
      }while(!strInput.equals("w") && !strInput.equals("a") && !strInput.equals("s") && !strInput.equals("d")
              && !strInput.equals("q") && !strInput.equals("c") && !strInput.equals("f"));
      return strInput;
   }

   public static void changeDirection(String mainInput, Player player){
      if(mainInput.equals("w")){
         player.setDirection('N');
      }else if(mainInput.equals("a")){
         player.setDirection(('W'));
      }else if(mainInput.equals("s")){
         player.setDirection('S');
      }else{
         player.setDirection('E');
      }
   }

   public static void changePlayerLocation(Player player){

   }

   public static Maps field(){
      int[][] map = {
              {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
              {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
      };
      int[][] zombieStartLocations = {{5,5}, {7,24}, {21,10}, {21,28}, {15,1}, {1,15}, {7,27}, {5,6}, {9,3}, {28,1},
              {24,24}, {1,25}};
      int[] playerStartLocation = {14,14};

      Maps field = new Maps(map, zombieStartLocations, playerStartLocation);
      return field;
   }
}