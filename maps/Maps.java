package maps;

import Player.Player;
import Zombie.Zombie;

public class Maps {
    // Attributes
    int[][] map;
    int level;
    private Player player1 = new Player();
    private Zombie zombie1 = new Zombie();
    private Zombie zombie2 = new Zombie();
    private Zombie zombie3 = new Zombie();
    private Zombie zombie4 = new Zombie();
    private Zombie zombie5 = new Zombie();
    private Zombie zombie6 = new Zombie();
    private Zombie zombie7 = new Zombie();
    private Zombie zombie8 = new Zombie();
    private Zombie zombie9 = new Zombie();
    private Zombie zombie10 = new Zombie();
    private Zombie zombie11 = new Zombie();
    private Zombie zombie12 = new Zombie();
    final Zombie[] zombieArray = {zombie1, zombie2, zombie3, zombie4, zombie5, zombie6, zombie7, zombie8, zombie9,
            zombie10, zombie11, zombie12};
    final int[][] zombieStartLocations;
    final int[] playerStartLocation;

    public Maps(int[][] map, int[][] zombieStartLocations, int[] playerStartLocation){
        this.map = map;
        this.zombieStartLocations = zombieStartLocations;
        this.playerStartLocation = playerStartLocation;
        this.level = 1;
        addEntities();
        //Add method that add positions upon creation
    }

    // Methods
    public void healZombies(){
        for (Zombie i : zombieArray){
            i.setHealth();
        }
    }

    public void resetStartPoints(){
        player1.setPosition(playerStartLocation);
        for (Zombie i : zombieArray){
            for (int[] j : zombieStartLocations){
                i.setLocation(j);
            }
        }
    }

    public void displayMap(){
        for (int i = 0; i < 30; i++){
            for (int j = 0; j < 30; j++){
                if (map[i][j] == 0){
                    System.out.print('-');
                } else if (map[i][j] == 1){
                    System.out.print(' ');
                } else if (map[i][j] == 2){
                    System.out.print('^');
                } else if (map[i][j] == 3){
                    System.out.print('|');
                } else if(map[i][j] == 10){
                    System.out.print('o');
                } else if(map[i][j] == 11){ // Displays player
                    if (this.player1.getDirection() == 'N'){
                        System.out.print('^');
                    } else if(this.player1.getDirection() == 'E'){
                        System.out.print('>');
                    } else if(this.player1.getDirection() == 'W'){
                        System.out.print('<');
                    } else {
                        System.out.print('V');
                    }
                }
            }
            System.out.println();
        }
    }

    private void addEntities(){
        int spawnCount = 2 + this.level;
        for (int i = 0; i < spawnCount; i++){
            zombieArray[i].setLocation(zombieStartLocations[i]);
            map[zombieStartLocations[i][0]][zombieStartLocations[i][1]] = 10;
        }
        map[playerStartLocation[0]][playerStartLocation[1]] = 11;
    }

    public boolean movePlayer(String movement){
        int[] position = player1.getPosition();
        switch (movement) {
            case "w":
                if (position[0] > 0) {
                    if (map[position[0] - 1][position[1]] == 1) {
                        position[0]--;
                        map[position[0] + 1][position[1]] = 1;
                        player1.setPosition(position);
                        player1.setDirection('N');
                        map[position[0]][position[1]] = 11;
                        return true;
                    }
                }
                break;
            case "s":
                if (position[0] < map.length - 1) {
                    if (map[position[0] + 1][position[1]] == 1) {
                        position[0]++;
                        map[position[0] - 1][position[1]] = 1;
                        player1.setPosition(position);
                        player1.setDirection('S');
                        map[position[0]][position[1]] = 11;
                        return true;
                    }
                }
                break;
            case "a":
                if (position[1] > 0) {
                    if (map[position[0]][position[1] - 1] == 1) {
                        position[1]--;
                        map[position[0]][position[1] + 1] = 1;
                        player1.setPosition(position);
                        player1.setDirection('W');
                        map[position[0]][position[1]] = 11;
                        return true;
                    }
                }
                break;
            case "d":
                if (position[1] < map[0].length - 1) {
                    if (map[position[0]][position[1] + 1] == 1) {
                        position[1]++;
                        map[position[0]][position[1] - 1] = 1;
                        player1.setPosition(position);
                        player1.setDirection('E');
                        map[position[0]][position[1]] = 11;
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    // Setters
    public void setMap(int[][] map) {
        this.map = map;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setZombie1(Zombie zombie1){
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

    // Getters
    public int[][] getMap() {
        return map;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Zombie getZombie1() {
        return zombie1;
    }

    public Zombie getZombie2() {
        return zombie2;
    }

    public Zombie getZombie3() {
        return zombie3;
    }

    public Zombie getZombie4() {
        return zombie4;
    }

    public Zombie getZombie5() {
        return zombie5;
    }

    public Zombie getZombie6() {
        return zombie6;
    }

    public Zombie getZombie7() {
        return zombie7;
    }

    public Zombie getZombie8() {
        return zombie8;
    }

    public Zombie getZombie9() {
        return zombie9;
    }

    public Zombie getZombie10() {
        return zombie10;
    }

    public Zombie getZombie11() {
        return zombie11;
    }

    public Zombie getZombie12() {
        return zombie12;
    }
}
