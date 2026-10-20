import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TileBlank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TileBlank extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    private GreenfootImage image4;
    private GreenfootImage image5;
    private GreenfootImage image6;
    private GreenfootImage image7;
    boolean flagged = false;
    boolean bombed = false;
    /**
     * Act - do whatever the TileBlank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MinesweeperBoard board = (MinesweeperBoard) getWorld();
        board.showText(board.minesweeperBoard[0][1], 100,100);
        image1 = new GreenfootImage("Mine.png"); 
        image2 = new GreenfootImage("BlankTile.png");
        image3 = new GreenfootImage("Flag.png");
        image4 = new GreenfootImage("Tile 1.png");
        image5 = new GreenfootImage("Tile 2.png");
        image6 = new GreenfootImage("Tile 3.png");
        image7 = new GreenfootImage("Tile 4.png");
        if (Greenfoot.mouseClicked(this))
        {
            if ((Greenfoot.isKeyDown("z")) && (bombed == false))
            {
                if ((flagged == false))
                {
                    setImage (image3);
                    flagged = true;
                }
                else if ((flagged == true))
                {
                    setImage (image2);
                    flagged = false;
                }
            }
            else
            {
                if (flagged == true)
                {
                    //do nothing, you can't click a flagged square
                }
                else if (flagged == false)
                {
                    World world = getWorld();
                    world.removeObject(this);
                }
            }
        }
    }  
}
