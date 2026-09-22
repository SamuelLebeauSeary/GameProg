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
    boolean flagged = false;
    boolean bombed = false;
    /**
     * Act - do whatever the TileBlank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        image1 = new GreenfootImage ("Mine.png"); 
        image2 = new GreenfootImage ("BlankTile.png");
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
                    /*normally, this would set a number, but of course I don't know how to
                    *do this yet, so I will just delete the tile for now
                    */
                    //set variable TileBlank to author TiileBlank
                    //delete TileBlank
                }
            }
        }
    }
}
