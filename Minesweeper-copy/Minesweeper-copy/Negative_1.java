import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Negative_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Negative_1 extends Actor
{
    int index = 0;
    private GreenfootImage choice1;
    public Negative_1(int index)
    {
        this.index = index;
    }
    public void act()
    {
        choice1 = new GreenfootImage("Tile -1 Select.png");
        if (Greenfoot.mouseClicked(this))
        {
            BetweenRounds.choice = this.index;
        }
        setImage(choice1);
    }
}
