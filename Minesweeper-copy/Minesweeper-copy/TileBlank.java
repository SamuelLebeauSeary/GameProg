import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TileBlank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TileBlank extends Actor
{
    
    /**
     * Act - do whatever the TileBlank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            World world = getWorld();
            world.removeObject(this);
        }
        // Add your action code here.
    }
}
