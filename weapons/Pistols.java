package weapons;

public class Pistols {
   int damage = 5;
   int range = 10;
   int ammo = 30;
   String name = "Pistol";

   // Setters and Getters
   public void setAmmo(){
      this.ammo += 15;
   }

   public String getName(){
      return this.name;
   }
}
