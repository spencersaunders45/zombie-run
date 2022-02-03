import java.util.*;

public class Main {
   public static void main(String[] args){
      Player user = new Player();
      int round = 1;
      String input = welcome();
      map(round, user);
   }


   public static String welcome(){
      System.out.print("\n\n\n\n\n\n");
      System.out.println("-------------Zombie Run-------------");
      System.out.println("          O      O         -O");
      System.out.println("          |--    |--      -/V");
      System.out.println("          |\\     |\\      -//");
      System.out.print("\n\n");
      System.out.println("How to play <h>");
      System.out.println("Play Zombie Run <p>");
      Scanner input = new Scanner(System.in);
      System.out.print("> ");
      String strInput = input.nextLine();
      input.close();
      return strInput;
   }


   public static void displayInstructions(){
      System.out.print("\n\n");
      System.out.println("The goal is to survive 10 waves of zombies. You will find ammo(*) and\nhealth packs(+) around the map each level. Walk over them to pick\nthem up. Each turn you can move twice and attack three times.");
      System.out.print("\n\n");
   }


   public static void map(int round, Player user){
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
         {3,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
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
      // Display the map and player data
      System.out.print("\n\n\n\n\n\n\n");
      System.out.println("UP(w) DOWN(s) LEFT(a) RIGHT(d)");
      System.out.println("Health: " + user.getHealth() + "          Round: " + round);
      System.out.println("Weapon: " + user.getWeaponName());
      System.out.println();
      for(int i = 0; i < 30; i++){
         for(int j = 0; j < 30; j++){
            if(map[i][j] == 0){
               System.out.print('-');
            } else if(map[i][j] == 1){
               System.out.print(' ');
            } else if(map[i][j] == 2){
               System.out.print('^');
            } else if(map[i][j] == 3){
               System.out.print('|');
            }
         }
         System.out.print('\n');
      }
   }



   public static Zombie[] enemies(int level){
      Zombie[] zomArr = {};
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



   public static void healEnemies(Zombie[] zomArr){
      for(Zombie i : zomArr){
         i.healZombie();
      }
   }

}