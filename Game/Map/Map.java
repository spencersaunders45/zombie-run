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

    public int[][] GetZomStart()
    {
        return new int[][]{zom1Start, zom2Start, zom3Start, zom4Start, zom5Start, zom6Start, zom7Start,
                zom8Start, zom9Start, zom10Start, zom11Start, zom12Start};
    }
}
