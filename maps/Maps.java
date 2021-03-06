package maps;

import Player.Player;
import Zombie.Zombie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

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
        addLocations();
    }

    // Methods
    private void addLocations(){
        int[] playerPosition = {playerStartLocation[0], playerStartLocation[1]};
        player1.setPosition(playerPosition);
        for (int i = 0; i < 12; i++){
            int[] tempPosition = {zombieStartLocations[i][0], zombieStartLocations[i][1]};
            zombieArray[i].setLocation(tempPosition);
            System.out.println(Arrays.toString(tempPosition));
        }

    }

    public void healZombies(){
        for (Zombie i : zombieArray){
            i.setHealth();
        }
    }

    public void resetStartPoints(){
        // Reset player position
        map[player1.getPosition()[0]][player1.getPosition()[1]] = 1;
        player1.setPosition(playerStartLocation);
        map[playerStartLocation[0]][playerStartLocation[1]] = 11;

        for (int i = 0; i < level + 1; i++){
            map[zombieArray[i].getLocation()[0]][zombieArray[i].getLocation()[1]] = 1;
            zombieArray[i].setLocation(zombieStartLocations[i]);
            map[zombieStartLocations[i][0]][zombieStartLocations[i][1]] = 10;
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

    private void applyZombieDamage(Zombie closestZombie){
        if (closestZombie != null){
            int[] isDead = closestZombie.shotZombie();
            int[] notDead = {0,0};
            if (isDead != notDead){
                map[isDead[0]][isDead[1]] = 1;
            }
        }
    }

    private Zombie findClosestZombie(ArrayList <Zombie> inRange){
        Zombie closestZombie = null;
        if (inRange.size() == 1){
            closestZombie = inRange.get(0);
        } else {
            for(int i = 0; i < inRange.size(); i++){
                if (closestZombie == null){
                    closestZombie = inRange.get(i);
                } else if (zombieArray[i].getLocation()[0] < closestZombie.getLocation()[0]){
                    closestZombie = inRange.get(i);
                }
            }
        }
        return closestZombie;
    }

    public void shootZombie(){
        int[] bulletLocation = player1.getPosition();
        ArrayList <Zombie> inRange = new ArrayList<Zombie>();
        Zombie closestZombie = null;
        // Loops through all zombies in the current level
        for(int i = 0; i < level + 2; i++){
            int[] zombieLocation = zombieArray[i].getLocation();
            // Checks to see if the Zombie is in the same column as the player
            if(zombieLocation[1] == bulletLocation[1]){
                // Checks to see if the zombie in the same column is ahead of bullet
                if (zombieLocation[0] < bulletLocation[0] && player1.getDirection() == 'N') {
                    inRange.add(zombieArray[i]);
                } else if (zombieLocation[0] > bulletLocation[0] && player1.getDirection() == 'S') {
                    System.out.println("here");
                    inRange.add(zombieArray[i]);
                }
            // Checks to see if Zombie is in the same row as the player
            } else if(zombieLocation[0] == bulletLocation[0]){
                if(zombieLocation[1] > bulletLocation[1] && player1.getDirection() == 'E') {
                    inRange.add(zombieArray[i]);
                } else if(zombieLocation[0] < bulletLocation[0] && player1.getDirection() == 'W') {
                    inRange.add(zombieArray[i]);
                }
            }
        }
        // Finds the closest Zombie
        if (inRange.size() > 0){
            closestZombie = findClosestZombie(inRange);
            applyZombieDamage(closestZombie);
        }
    }

    private boolean zombieMoveValidation(int[] position){
        return map[position[0]][position[1]] == 1;
    }

    public void moveZombie(){
        int[] playerPosition = player1.getPosition();
        for (int i = 0; i < level + 2; i++){
            int[] position = zombieArray[i].getLocation();
            Random random = new Random();
            int value = random.nextInt(2);
            int[] newPosition;
            // Movement when top right
            if (position[0] > playerPosition[0] && position[1] > playerPosition[1]){
                if (value == 0){
                    newPosition = new int[]{position[0] - 1, position[1]};
                } else {
                    newPosition = new int[]{position[0], position[1] - 1};
                }
                if (zombieMoveValidation(newPosition)){
                    map[position[0]][position[1]] = 1;
                    map[newPosition[0]][newPosition[1]] = 10;
                    zombieArray[i].setLocation(newPosition);
                }
            // Movement when top left
            } else if (position[0] > playerPosition[0] && position[1] < playerPosition[1]){
                if (value == 0){
                    newPosition = new int[]{position[0] - 1, position[1]};
                } else {
                    newPosition = new int[]{position[0], position[1] + 1};
                }
                if (zombieMoveValidation(newPosition)){
                    map[position[0]][position[1]] = 1;
                    map[newPosition[0]][newPosition[1]] = 10;
                    zombieArray[i].setLocation(newPosition);
                }
            // Movement when bottom left
            } else if (position[0] < playerPosition[0] && position[1] < playerPosition[1]){
                if (value == 0){
                    newPosition = new int[]{position[0] + 1, position[1]};
                } else {
                    newPosition = new int[]{position[0], position[1] + 1};
                }
                if (zombieMoveValidation(newPosition)){
                    map[position[0]][position[1]] = 1;
                    map[newPosition[0]][newPosition[1]] = 10;
                    zombieArray[i].setLocation(newPosition);
                }
            // Movement bottom right
            } else if (position[0] < playerPosition[0] && position[1] > playerPosition[1]){
                if (value == 0){
                    newPosition = new int[]{position[0] + 1, position[1]};
                } else {
                    newPosition = new int[]{position[0], position[1] - 1};
                }
                if (zombieMoveValidation(newPosition)){
                    map[position[0]][position[1]] = 1;
                    map[newPosition[0]][newPosition[1]] = 10;
                    zombieArray[i].setLocation(newPosition);
                }
            // Above player
            } else if (position[0] > playerPosition[0]){
                newPosition = new int[]{position[0] - 1, position[1]};
                if (zombieMoveValidation(newPosition)){
                    map[position[0]][position[1]] = 1;
                    map[newPosition[0]][newPosition[1]] = 10;
                    zombieArray[i].setLocation(newPosition);
                }
            // Below player
            } else if (position[0] < playerPosition[0]){
                newPosition = new int[]{position[0] + 1, position[1]};
                if (zombieMoveValidation(newPosition)){
                    map[position[0]][position[1]] = 1;
                    map[newPosition[0]][newPosition[1]] = 10;
                    zombieArray[i].setLocation(newPosition);
                }
            // Left of player
            } else if (position[1] < playerPosition[1]){
                newPosition = new int[]{position[0], position[1] + 1};
                if (zombieMoveValidation(newPosition)){
                    map[position[0]][position[1]] = 1;
                    map[newPosition[0]][newPosition[1]] = 10;
                    zombieArray[i].setLocation(newPosition);
                }
            // Right of player
            } else if (position[1] > playerPosition[1]){
                newPosition = new int[]{position[0], position[1] - 1};
                if (zombieMoveValidation(newPosition)){
                    map[position[0]][position[1]] = 1;
                    map[newPosition[0]][newPosition[1]] = 10;
                    zombieArray[i].setLocation(newPosition);
                }
            }
        }
    }

    public void attackPlayer(){
        int[] playerPosition = player1.getPosition();
        for(int i = 0; i < level + 2; i++){
            int[] zombiePosition = zombieArray[i].getLocation();
            int yPosition = zombiePosition[0];
            int xPosition = zombiePosition[1];
            int[] checkNorth = {yPosition - 1, xPosition};
            int[] checkSouth = {yPosition + 1, xPosition};
            int[] checkWest = {yPosition, xPosition - 1};
            int[] checkEast = {yPosition, xPosition + 1};
            if (Arrays.equals(checkNorth, playerPosition)){
                player1.damagePlayer(20);
                return;
            } else if (Arrays.equals(checkSouth, playerPosition)){
                player1.damagePlayer(20);
                return;
            } else if (Arrays.equals(checkWest, playerPosition)){
                player1.damagePlayer(20);
                return;
            } else if (Arrays.equals(checkEast, playerPosition)){
                player1.damagePlayer(20);
                return;
            }
        }
    }

    public boolean checkZombies(){
        int deathCount = 0;
        for (int i = 0; i < level + 2; i++){
            if (zombieArray[i].getHealth() == 0){
                deathCount++;
            }
        }
        if (deathCount == level + 2){
            level++;
            healZombies();
            resetStartPoints();
            return true;
        }
        return false;
    }

    // Setters

    // Getters
    public Player getPlayer1(){
        return player1;
    }
}
