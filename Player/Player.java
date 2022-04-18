package Player;

import weapons.Pistols;

public class Player {
   int health = 100;
   char direction = 'N';
   int[] position;
   Pistols pistol = new Pistols();
   String weaponName = "Pistol";

   //Methods


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

   public char getDirection() {
      return direction;
   }
}
