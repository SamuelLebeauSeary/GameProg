import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
    private GreenfootImage image12;
    private GreenfootImage image13;
    private GreenfootImage image14;
    boolean flagged = false;
    boolean bombed = false;
    boolean revealed = false;
    public String mineBoard[][];
    MinesweeperBoard board; 
    public TileBlank()
    {
        board = (MinesweeperBoard) getWorld();
        image1 = new GreenfootImage("Mine.png"); 
        image2 = new GreenfootImage("BlankTile.png");
        image3 = new GreenfootImage("Flag.png");
        image4 = new GreenfootImage("Tile 1.png");
        image5 = new GreenfootImage("Tile 2.png");
        image6 = new GreenfootImage("Tile 3.png");
        image7 = new GreenfootImage("Tile 4.png");
        image8 = new GreenfootImage("Tile 5.png");
        image9 = new GreenfootImage("Tile 6.png");
        image10 = new GreenfootImage("Tile 7.png");
        image11 = new GreenfootImage("Tile 8.png");
        image12 = new GreenfootImage("Tile 0.png");
        image13 = new GreenfootImage("Tile Compass.png");
        image14 = new GreenfootImage("Tile Diagonal.png");
    }
    /**
     * Act - do whatever the TileBlank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (board == null)
        {
            board = (MinesweeperBoard) getWorld();
        }
        mineBoard = board.minesweeperBoard;
        int xCoord = this.getX() / 32;
        int yCoord = this.getY() / 32;
        if (Greenfoot.mouseClicked(this))
        {
            if ((Greenfoot.isKeyDown("z")) && (bombed == false))
            {
                if ((flagged == false && revealed == false))
                {
                    setImage (image3);
                    flagged = true;
                    board.addFlag();
                }
                else if ((flagged == true))
                {
                    setImage (image2);
                    flagged = false;
                    board.removeFlag();
                }
            }
            else if (revealed == false && flagged == false && bombed == false) 
            {
                revealTile(xCoord, yCoord);
                if  (Button.tileCompass > 0){
                    activateCompass();
                }
            }
        }
        if (board.getTotalBlanks() == 0){
            World BetweenRounds = new BetweenRounds();
            Greenfoot.setWorld(BetweenRounds);
        }
    }


    public void revealEmptyCourt()
    {
        // Flood fill: tell all 8 surrounding TileBlank actors to reveal themselves
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Skip the center tile (itself)
                if (i == 0 && j == 0) {
                    continue;
                }


                // Calculate pixel coordinates of the neighbor (each tile is 32x32)
                int neighborPixelX = getX() + (i * 32);
                int neighborPixelY = getY() + (j * 32);


                // Find the TileBlank actor at that pixel location
                List<TileBlank> neighbors = getWorld().getObjectsAt(neighborPixelX, neighborPixelY, TileBlank.class);


                if (!neighbors.isEmpty()) {
                    TileBlank neighbor = neighbors.get(0);
                    int nextX = neighbor.getX() / 32;
                    int nextY = neighbor.getY() / 32;
                    neighbor.revealTile(nextX, nextY);
                }
            }
        }
    }

    public void revealTile(int xCoord, int yCoord)
    {
        // 1. Early exit: already uncovered, flagged, or bombed
        if (revealed || flagged || bombed) {
            return;
        }
        if (mineBoard == null || board == null)
        {
            return;
        }
        int rows = mineBoard.length;
        int cols = mineBoard[0].length;
    
        // 2. Early exit: coordinates out of array bounds
        if (xCoord < 0 || xCoord >= rows || yCoord < 0 || yCoord >= cols) {
            return;
        }
        int mineCount = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nextX = xCoord + i;
                int nextY = yCoord + j;
                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols) {
                    if (mineBoard[nextX][nextY].equals("m")) {
                        mineCount++;
                    }
                }
            }
        }
        
        revealed = true; // make sure a revealed tile was revealed
        board.updateBlanks();
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
                setImage(image8);
            }
            else if (mineCount == 6){
                setImage(image9);
            }
            else if (mineCount == 7){
                setImage(image10);
            }
            else if (mineCount == 8){
                setImage(image11);
            }
        } else {
            setImage(image12);
            revealEmptyCourt();
        }    
    }
    public void activateCompass()
    {
            if (Button.tileCompass > 0)
            {
                int r = Greenfoot.getRandomNumber(11);
                if (r == 10)
                {
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i == 0 && j == 0) {
                             continue;
                            }
                            int neighborPixelX = getX() + (i * 32);
                            int neighborPixelY = getY() + (j * 32);
                            List<TileBlank> blankneighbors = getWorld().getObjectsAt(neighborPixelX, neighborPixelY, TileBlank.class);
                            if (!blankneighbors.isEmpty())
                            {
                                TileBlank neighbor = blankneighbors.get(0);
                                int nextX = neighbor.getX() / 32;
                                int nextY = neighbor.getY() / 32;
                                neighbor.revealTile(nextX, nextY);
                            }
                            List<TileMine> mineNeighbors = getWorld().getObjectsAt (neighborPixelX, neighborPixelY, TileMine.class);
                            if (!mineNeighbors.isEmpty()){
                                TileMine mine = mineNeighbors.get(0);
                                mine.setImage("Tile Compass.png");
                                mine.bombed = true;
                                mine.flagged = true;
                            }
                        }
                    }
                }
            }
    }
    public void activateLines(){
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
            }
        }
    }
}