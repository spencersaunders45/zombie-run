package weapons;

public class Shotgun {
   int damage = 10;
   int range = 2;
   int ammo = 5;
   String name = "Shotgun";

   // Setters
   public void setAmmo(){
      this.ammo += 8;
   }

   // Getters
   public String getName(){
      return this.name;
   }

   public int getAmmo(){
      return ammo;
   }
}
