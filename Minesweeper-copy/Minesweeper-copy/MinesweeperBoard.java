import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinesweeperBoard extends World
{
    public String [] [] minesweeperBoard;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MinesweeperBoard()
    {    
        super(512, 512, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        int x = 16;
        int y = 16;
        int m = 0;
        int n = 0;
        int n2 = 0;
        minesweeperBoard = new String [16][16];
        for (int row = 0; row < 16; row++)
        {
            for (int col = 0; col < 16; col++)
            {
                if (Greenfoot.getRandomNumber(5) == 1) {
                    TileMine tileMine = new TileMine();
                    addObject(tileMine, x + col * 32, x + row * 32);
                    minesweeperBoard [n][m] = "m";
                    n++;
                }
                else{
                    TileBlank tileBlank = new TileBlank();
                    addObject(tileBlank, x + col * 32, y + row * 32);
                    minesweeperBoard [n] [m] = "b";
                    n++;
                }
            }
            m++;
            n = 0;
        }
        /*
         * this next section is to see which tiles are mines for testing
         */
        for (int row2 = 0; row2 < 16; ++row2){
            System.out.println(minesweeperBoard[0][n2] + " " +
            minesweeperBoard[1][n2] + " " +
            minesweeperBoard[2][n2] + " " +
            minesweeperBoard[3][n2] + " " +
            minesweeperBoard[4][n2] + " " +
            minesweeperBoard[5][n2] + " " +
            minesweeperBoard[6][n2] + " " +
            minesweeperBoard[7][n2] + " " +
            minesweeperBoard[8][n2] + " " +
            minesweeperBoard[9][n2] + " " +
            minesweeperBoard[10][n2] + " " +
            minesweeperBoard[11][n2] + " " +
            minesweeperBoard[12][n2] + " " +
            minesweeperBoard[13][n2] + " " +
            minesweeperBoard[14][n2] + " " +
            minesweeperBoard[15][n2]
            );
            n2++;
        }
    }
}

