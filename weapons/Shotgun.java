package weapons;

public class Shotgun {
   int damage = 10;
   int range = 2;
   int ammo = 5;
   String name = "weapons.Shotgun";

   // Setters and Getters
   public void setAmmo(){
      this.ammo += 8;
   }

   public String getName(){
      return this.name;
   }
}
