import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BetweenRounds extends World
{
    private GreenfootImage choice1;
    private int option1;
    private int option2;
    private int option3;
    public static int choice = -1;
    public BetweenRounds()
    {    
        super(320, 160, 1);
        choice1 = new GreenfootImage("Tile -1 Select.png");
        prepare();
    }
    private void prepare(){
        option1 = Greenfoot.getRandomNumber(3);
        option2 = Greenfoot.getRandomNumber(3);
        option3 = Greenfoot.getRandomNumber(3);
        
   
        
        addObject(new Negative_1(0), 50,50);
        addObject(new Negative_1(1), 100,50);
        addObject(new Negative_1(2), 150,50);
        
        choices();
    }
    public void choices(){
        choice = 2;
    }
}
