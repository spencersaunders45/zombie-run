package Game.Map;

public class Map {

    int[][] map;
    int[] playerStart;
    int[] zom1Start;
    int[] zom2Start;
    int[] zom3Start;
    int[] zom4Start;
    int[] zom5Start;
    int[] zom6Start;
    int[] zom7Start;
    int[] zom8Start;
    int[] zom9Start;
    int[] zom10Start;
    int[] zom11Start;
    int[] zom12Start;

    public Map()
    {

    }

    public int[][] GetMap()
    {
        return map;
    }

    public int[] GetPlayerStart()
    {
        return playerStart;
    }

    public int[][] GetZombieStart()
    {
        return new int[][]{zom1Start, zom2Start, zom3Start, zom4Start, zom5Start, zom6Start, zom7Start,
                zom8Start, zom9Start, zom10Start, zom11Start, zom12Start};
    }

    private void SetPlayerStart(int[] playerStart)
    {
        this.playerStart = playerStart;
    }

    private void SetZombieStart(int[][] zomStartArray)
    {
        this.zom1Start = zomStartArray[0];
        this.zom2Start = zomStartArray[1];
        this.zom3Start = zomStartArray[2];
        this.zom4Start = zomStartArray[3];
        this.zom5Start = zomStartArray[4];
        this.zom6Start = zomStartArray[5];
        this.zom7Start = zomStartArray[6];
        this.zom8Start = zomStartArray[7];
        this.zom9Start = zomStartArray[8];
        this.zom10Start = zomStartArray[9];
        this.zom11Start = zomStartArray[10];
        this.zom12Start = zomStartArray[11];
    }

    private void SetMap(int[][] map)
    {
        this.map = map;
    }

    private void SelectMap(String mapName)
    {
        if (mapName == )
    }

    private void Field()
    {

    }

    private void City()
    {

    }

    private void Highway()
    {

    }
}
