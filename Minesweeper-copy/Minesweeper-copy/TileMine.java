import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private GreenfootImage background;
    boolean clicked = false;
    /**
     * Act - do whatever the TileBlank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        image1 = new GreenfootImage ("Mine.png"); 
        image2 = new GreenfootImage ("BlankTile.png");
        background = new GreenfootImage ("Background.png");
        if (Greenfoot.mouseClicked(this) && Greenfoot.isKeyDown("z") == false) 
        {
            setImage (image1);
            clicked = true;
        }
        else if (clicked == true)
        {
            setImage (image1);
        }
        else if (Greenfoot.mouseClicked(this) && Greenfoot.isKeyDown("z") && clicked == false)
        {
            setImage (background);
        }
        else
        {
            setImage (image2);
        }
    }
}
