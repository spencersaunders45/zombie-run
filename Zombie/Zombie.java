package Zombie;

import java.util.Arrays;

public class Zombie {
   int health = 20;
   int speed = 1;
   int attack = 10;
   int[] location;
   boolean killed = false;

   // Methods
   public int[] shotZombie(){
      health -= 10;
      if (health <= 0){
         killed = true;
         int[] deathLocation = location;
         setLocation(new int[]{0,0});
         return deathLocation;
      } else {
         return new int[]{0,0};
      }
   }

   public void printLocation(){
      System.out.println(Arrays.toString(location));
   }

   // Getters
   public int[] getLocation(){
      return location;
   }

   public int getSpeed(){
      return speed;
   }

   public int getAttack(){
      return attack;
   }

   public int getHealth() {
      return health;
   }

   public boolean getKilled(){
      return killed;
   }

   // Setters
   public void setHealth(){
      this.health = 10;
   }

   public void setLocation(int[] location){
      this.location = location;
   }

   public void setKilled(boolean killed){
      this.killed = killed;
   }
}
