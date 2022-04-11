package Player;

import weapons.Pistols;
import weapons.Rifle;
import weapons.Shotgun;

public class Player {
   int health = 100;
   char direction = 'N';
   int[] position;
   Pistols pistol = new Pistols();
   Shotgun shotgun = new Shotgun();
   Rifle rifle = new Rifle();
   Object weapon = pistol;
   String weaponName = "Pistol";

   //Methods
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

   // Setters
   public void damagePlayer(int damage){
      health -= damage;
   }

   public void setDirection(char direction){
      this.direction = direction;
   }

   public void setPosition(int[] position){
      this.position = position;
   }

   // Getters
   public String getWeaponName(){
      return weaponName;
   }

   public int getHealth(){
      return health;
   }

   public int[] getPosition(){
      return position;
   }

   public Pistols getPistol(){
      return pistol;
   }

   public Rifle getRifle(){
      return rifle;
   }

   public Shotgun getShotgun(){
      return shotgun;
   }

   public char getDirection() {
      return direction;
   }
}
