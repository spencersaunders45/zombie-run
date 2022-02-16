package weapons;

public class Pistols {
   int damage = 5;
   int range = 10;
   int ammo = 30;
   String name = "Pistol";

   // Setters
   public void setAmmo(){
      this.ammo += 15;
   }

   // Getters
   public String getName(){
      return this.name;
   }

   public int getAmmo(){
      return ammo;
   }

   public int getDamage(){
      return damage;
   }

   public int getRange(){
      return range;
   }
}
