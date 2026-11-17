import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BetweenRounds extends World
{
    public static int choice;
    public BetweenRounds()
    {    
        super(320, 160, 1);
        prepare();
    }
    private void prepare(){
        addObject(new Button(), 63,80);
        addObject(new Button(), 160,80);
        addObject(new Button(), 257,80);
    }
}
