import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class TileMine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TileMine extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    private GreenfootImage image4;
    boolean flagged = false;
    boolean bombed = false;
    MinesweeperBoard board;
    /**
     * Act - do whatever the TileBlank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        image1 = new GreenfootImage ("Mine.png"); 
        image2 = new GreenfootImage ("BlankTile.png");
        image3 = new GreenfootImage ("Flag.png");
        image4 = new GreenfootImage ("Tile -1.png");
        board = (MinesweeperBoard) getWorld();
        if (Greenfoot.mouseClicked(this))
        {
            if (Greenfoot.isKeyDown("z"))
            {
                if ((flagged == false) && (bombed == false))
                {
                    setImage (image3);
                    flagged = true;
                    board.addFlag();
                }
                else if (flagged == true && bombed == false)
                {
                    setImage (image2);
                    flagged = false;
                    board.removeFlag();
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
                    if (Button.minusOne > 0)
                    {
                            setImage(image4);
                            Button.minusOne--;
                            bombed = true;
                            flagged = true;
                    }else{
                            setImage (image1);
                            bombed = true;
                            World gameOverWorld = new GameOverWorld();
                            Greenfoot.setWorld(gameOverWorld);
                    }
                }
            } 
        }
    }
}
