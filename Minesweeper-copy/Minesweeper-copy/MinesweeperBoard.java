import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinesweeperBoard extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MinesweeperBoard()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
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
        for (int row = 0; row < 16; row++)
        {
            for (int col = 0; col < 16; col++)
            {
                //if (Greenfoot.getRandomNumber(10)){
                //stuff idk    
                
                TileBlank tileBlank = new TileBlank();
                addObject(tileBlank, x + col * 32, y + row * 32);
            }
        }
    }
}

