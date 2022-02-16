package weapons;

public class Rifle {
   int damage = 10;
   int range = 30;
   int ammo = 5;
   String name = "Rifle";

   // Setters
   public void setAmmo(){
      this.ammo += 10;
   }

   // Getters
   public String getName(){
      return this.name;
   }

   public int getRange(){
      return range;
   }

   public int getDamage(){
      return damage;
   }

   public int getAmmo(){
      return ammo;
   }
}
