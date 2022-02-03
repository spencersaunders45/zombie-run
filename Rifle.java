public class Rifle {
   int damage = 10;
   int range = 30;
   int ammo = 5;
   String name = "Rifle";

   public void setAmmo(){
      this.ammo += 10;
   }

   public String getName(){
      return this.name;
   }
}
