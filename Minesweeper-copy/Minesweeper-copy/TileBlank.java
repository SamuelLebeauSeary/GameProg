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
    private GreenfootImage image8;
    private GreenfootImage image9;
    private GreenfootImage image10;
    private GreenfootImage image11;
    boolean flagged = false;
    boolean bombed = false;
    public String mineBoard[][];
    /**
     * Act - do whatever the TileBlank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MinesweeperBoard board = (MinesweeperBoard) getWorld();
        image1 = new GreenfootImage("Mine.png"); 
        image2 = new GreenfootImage("BlankTile.png");
        image3 = new GreenfootImage("Flag.png");
        image4 = new GreenfootImage("Tile 1.png");
        image5 = new GreenfootImage("Tile 2.png");
        image6 = new GreenfootImage("Tile 3.png");
        image7 = new GreenfootImage("Tile 4.png");
        //image8 = new GreenfootImage("Tile 5.png");
        //image9 = new GreenfootImage("Tile 6.png");
        //image10 = new GreenfootImage("Tile 7.png");
        //image11 = new GreenfootImage("Tile 8.png");
        mineBoard = board.minesweeperBoard;
        int yCoord = this.getX() / 32;
        int xCoord = this.getX() / 32;
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
                if (flagged) { 
                    // Do nothing, it's flagged
                } else {
                    int mineCount = 0;
                    int rows = mineBoard.length;
                    int cols = mineBoard[0].length;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int neighborX = xCoord + i;
                            int neighborY = yCoord + j;
                            if (neighborX >= 0 && neighborX < rows && neighborY >= 0 && neighborY < cols) {
                                if (mineBoard[neighborX][neighborY].equals("m")) {
                                    mineCount++;
                                }
                            }
                        }
                    }
                    if (mineCount > 0) {
                        if (mineCount == 1){
                            setImage(image4);
                        }
                        else if (mineCount == 2){
                            setImage(image5);
                        }
                        else if (mineCount == 3){
                            setImage(image6);
                        }
                        else if (mineCount == 4){
                            setImage(image7);
                        }
                        else if (mineCount == 5){
                            //setImage(image8);
                        }
                        else if (mineCount == 6){
                            //setImage(image9);
                        }
                        else if (mineCount == 7){
                            //setImage(image10);
                        }
                        else if (mineCount == 8){
                            //setImage(image11);
                        }
                    } else {
                        //clear surrounding squares I guess
                    }
                }
            }
        }
    }  
}
