import java.util.*;

import Player.Player;
import Zombie.Zombie;
import maps.Field;

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

      // Game loop
      if(mainInput.equals("p")){
         gameActive = true;

         // Pick the map
         mainInput = mapSelection(input);
         if (mainInput == "field"){
            Field selectedMap = new Field();
         } else if(mainInput == "city"){
            // City selectedMap = new City();
         } else if(mainInput == "highway"){
            // Highway selectedMap = new Highway();
         } else {
            System.out.println("Error: No map selected");
            return;
         }
         while(gameActive == true){
            displayHud();
            displayMap(selectedMap);
            mainInput = action(input);
            if(mainInput.equals("q")){
               break;
            }
         }
      }
      System.out.println("Thanks for playing!");
      input.close();
   }




   public static String welcome(Scanner input){
      System.out.print("\n\n\n\n\n\n");
      System.out.println("-------------Zombie.Zombie Run-------------\n");
      System.out.println("          O      O         -O");
      System.out.println("          |--    |--      -/V");
      System.out.println("          |\\     |\\      -//");
      System.out.print("\n\n");
      System.out.println("How to play <h>");
      System.out.println("Play Zombie.Zombie Run <p>");
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

   public static Zombie[] enemies(int level, Zombie[] zomArr){
      if(level == 1){
         Zombie zombie1 = new Zombie();
         Zombie zombie2 = new Zombie();
         Zombie zombie3 = new Zombie();
         zomArr[0] = zombie1;
         zomArr[1] = zombie2;
         zomArr[2] = zombie3;
      } else if(level == 2){
         Zombie zombie4 = new Zombie();
         zomArr[3] = zombie4;
      } else if(level == 3){
         Zombie zombie5 = new Zombie();
         zomArr[4] = zombie5;
      } else if(level == 4){
         Zombie zombie6 = new Zombie();
         zomArr[5] = zombie6;
      } else if(level == 5){
         Zombie zombie7 = new Zombie();
         zomArr[6] = zombie7;
      } else if(level == 6){
         Zombie zombie8 = new Zombie();
         zomArr[7] = zombie8;
      } else if(level == 7){
         Zombie zombie9 = new Zombie();
         zomArr[8] = zombie9;
      } else if(level == 8){
         Zombie zombie10 = new Zombie();
         zomArr[9] = zombie10;
      } else if(level == 9){
         Zombie zombie11 = new Zombie();
         zomArr[10] = zombie11;
      } else if(level == 10){
         Zombie zombie12 = new Zombie();
         zomArr[11] = zombie12;
      }
      return zomArr;
   }

   public static String action(Scanner input){
      System.out.println();
      String strInput;
      do{
         System.out.print("> ");
         strInput = input.nextLine();
      }while(!strInput.equals("w") && !strInput.equals("a") && !strInput.equals("s") && !strInput.equals("d")
              && !strInput.equals("q") && !strInput.equals("c") && !strInput.equals("f"));
      return strInput;
   }

   public static void changeDirection(String mainInput, Player user){
      if(mainInput.equals("w")){
         user.setDirection('N');
      }else if(mainInput.equals("a")){
         user.setDirection(('W'));
      }else if(mainInput.equals("s")){
         user.setDirection('S');
      }else{
         user.setDirection('E');
      }
   }
}