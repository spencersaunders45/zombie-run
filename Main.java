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
            displayHud(game);
            game.displayMap();
            mainInput = action(input);
            if(mainInput.equals("q")){ // Ends the game
               break;
            } else if (mainInput.equals("w") || mainInput.equals("s") || // Moves the player
                    mainInput.equals("a") || mainInput.equals("d")){
               boolean isValid = true;
               do{
                  if (isValid == false){
                     System.out.println("Cannot move there: try again");
                     mainInput = action(input);
                  }
                  isValid = game.movePlayer(mainInput);
               }while (isValid == false);
            } else if (mainInput.equals("f")){ // Shoots zombies
               //code here
            } else {
               System.out.println("Error: Unknown input");
               return;
            }
         }
      }
      System.out.println("Thanks for playing!");
      input.close();
   }

   public static void displayHud(Maps game){
      Player player = game.getPlayer1();
      System.out.print("\n\n\n\n");
      System.out.println("Health: " + player.getHealth());
      if (player.getWeaponName().equals("Pistol")){
         System.out.println("Gun: " + player.getWeaponName() +"     Ammo:" + player.getPistol().getAmmo());
      } else if (player.getWeaponName().equals("Rifle")){
         System.out.println("Gun: " + player.getWeaponName() +"     Ammo:" + player.getRifle().getAmmo());
      } else if (player.getWeaponName().equals("Shotgun")){
         System.out.println("Gun: " + player.getWeaponName() +"     Ammo:" + player.getShotgun().getAmmo());
      }
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