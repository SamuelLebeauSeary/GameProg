import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    int index;
    private GreenfootImage pick1;
    private GreenfootImage pick2;
    private GreenfootImage pick3;
    static int minusOne = 0;
    static int tileCompass = 0;
    static int diagonal = 0;
    BetweenRounds between;
    public Button()
    {
        index = Greenfoot.getRandomNumber(3);
        between = (BetweenRounds) getWorld();
    }
    public void act()
    {
        pick1 = new GreenfootImage ("Tile -1 Select.png");
        pick2 = new GreenfootImage ("Tile Compass Select.png");
        pick3 = new GreenfootImage ("Tile Diagonal Select.png");
        MinesweeperBoard MinesweeperBoard = new MinesweeperBoard();
        if (index == 0){
            setImage(pick1);
            if (Greenfoot.mouseClicked(this)){
                between.choice = 1;
                minusOne++;
                Greenfoot.setWorld(MinesweeperBoard);
            }
        }
        if (index == 1){
            setImage(pick2);
            if (Greenfoot.mouseClicked(this)){
                between.choice = 2;
                tileCompass++;
                Greenfoot.setWorld(MinesweeperBoard);
            }
        }
        if (index == 2){
            setImage(pick3);
            if (Greenfoot.mouseClicked(this)){
                between.choice = 3;
                diagonal++;
                Greenfoot.setWorld(MinesweeperBoard);
            }
        }
    }
}
