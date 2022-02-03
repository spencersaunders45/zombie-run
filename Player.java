public class Player {
   int health = 100;
   int speed = 1;
   char direction = 'N';
   Pistols pistol = new Pistols();
   Shotgun shotgun = new Shotgun();
   Rifle rifle = new Rifle();
   Object weapon = pistol;
   String weaponName = "Pistol";

   public void changeWeapon(int weaponNum){
      if(weaponNum == 1){
         this.weapon = pistol;
         weaponName = pistol.getName();
      } else if(weaponNum == 2){
         this.weapon = shotgun;
         weaponName = shotgun.getName();
      } else {
         this.weapon = rifle;
         weaponName = rifle.getName();
      }
   }


   // Setters and Getters
   public void setHealth(){
      this.health += 50;
      if(this.health > 100){
         this.health = 100;
      }
   }

   public String getWeaponName(){
      return this.weaponName;
   }

   public int getHealth(){
      return this.health;
   }
}
