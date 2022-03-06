package Zombie;

public class Zombie {
   int health = 20;
   int speed = 1;
   int attack = 10;
   int[] location;
   boolean killed = false;

   // Methods
   public void shotZombie(){
      health -= 10;
      if (health <= 0){
         killed = true;
         int[] killedLocation = {0,0};
         setLocation(killedLocation);
      }
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