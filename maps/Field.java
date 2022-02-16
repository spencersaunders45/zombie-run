package maps;

import Player.Player;
import Zombie.Zombie;

public class Field {
    // Attributes
    private int[][] map = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    private Zombie zombie1 = new Zombie();
    final int[] zombie1Location = {5,5};

    private Zombie zombie2 = new Zombie();
    final int[] zombie2Location = {7,24};

    private Zombie zombie3 = new Zombie();
    final int[] zombie3Location = {21,10};

    private Zombie zombie4 = new Zombie();
    final int[] zombie4Location = {21,28};

    private Zombie zombie5 = new Zombie();
    final int[] zombie5Location = {15,1};

    private Zombie zombie6 = new Zombie();
    final int[] zombie6Location = {1,15};

    private Zombie zombie7 = new Zombie();
    final int[] zombie7Location = {7,27};

    private Zombie zombie8 = new Zombie();
    final int[] zombie8Location = {5,6};

    private Zombie zombie9 = new Zombie();
    final int[] zombie9Location = {9,3};

    private Zombie zombie10 = new Zombie();
    final int[] zombie10Location = {28,1};

    private Zombie zombie11 = new Zombie();
    final int[] zombie11Location = {24,24};

    private Zombie zombie12 = new Zombie();
    final int[] zombie12Location = {1,25};

    private Player player1 = new Player();
    final int[] player1Location = {14,14};

    final Zombie[] zombieList = {zombie1, zombie2, zombie3, zombie4, zombie5, zombie6, zombie7, zombie8, zombie9, zombie10, zombie11, zombie12};
    final int[][] zombieStartLocations = {zombie1Location, zombie2Location, zombie3Location, zombie4Location, zombie5Location, zombie6Location, zombie7Location, zombie8Location, zombie9Location, zombie10Location, zombie11Location, zombie12Location};

    // Methods
    public void healZombies(){
        for (Zombie i : zombieList){
            i.setHealth();
        }
    }

    public void resetStartLocations(){
        for (Zombie i : zombieList){
            for (int[] j : zombieStartLocations){
                i.setLocation(j);
            }
        }
    }

    // Getters
    public int[][] getMap() {
        return map;
    }

    public int[] getPlayer1Location(){
        return player1Location;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Zombie getZombie1() {
        return zombie1;
    }

    public Zombie getZombie2(){
        return zombie2;
    }

    public Zombie getZombie3(){
        return zombie3;
    }

    public Zombie getZombie4(){
        return zombie4;
    }

    public Zombie getZombie5(){
        return zombie5;
    }

    public Zombie getZombie6(){
        return zombie6;
    }

    public Zombie getZombie7(){
        return zombie7;
    }

    public Zombie getZombie8(){
        return zombie8;
    }

    public Zombie getZombie9(){
        return zombie9;
    }

    public Zombie getZombie10(){
        return zombie10;
    }

    public Zombie getZombie11(){
        return zombie11;
    }

    public Zombie getZombie12(){
        return zombie12;
    }

    // Setters
    public void setMap(int[][] map) {
        this.map = map;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setZombie1(Zombie zombie1) {
        this.zombie1 = zombie1;
    }

    public void setZombie2(Zombie zombie2) {
        this.zombie2 = zombie2;
    }

    public void setZombie3(Zombie zombie3) {
        this.zombie3 = zombie3;
    }

    public void setZombie4(Zombie zombie4) {
        this.zombie4 = zombie4;
    }

    public void setZombie5(Zombie zombie5) {
        this.zombie5 = zombie5;
    }

    public void setZombie6(Zombie zombie6) {
        this.zombie6 = zombie6;
    }

    public void setZombie7(Zombie zombie7) {
        this.zombie7 = zombie7;
    }

    public void setZombie8(Zombie zombie8) {
        this.zombie8 = zombie8;
    }

    public void setZombie9(Zombie zombie9) {
        this.zombie9 = zombie9;
    }

    public void setZombie10(Zombie zombie10) {
        this.zombie10 = zombie10;
    }

    public void setZombie11(Zombie zombie11) {
        this.zombie11 = zombie11;
    }

    public void setZombie12(Zombie zombie12) {
        this.zombie12 = zombie12;
    }
}
