
/**
 * Write a description of class Rover here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rover
{
    // instance variables
    private String name;
    private int x;
    private int y;
    private int dir;
    private int health;
    private boolean isAlive;
    

    /**
     * Constructor for objects of class Rover
     */
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.isAlive = true;
    }
    
    public Rover(String name, int x, int y, int dir, int health)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.health = health;
        this.isAlive = true;
    }
    
    /**
     * Returns direction as a string instead of a number
     * 
     * @param dir The direction of the rover as a number 
     */
    private String getDirectionName(int dir){
        String direction;
        
        if (dir == 0){
            direction = "North";
        }
        else if (dir == 1){
            direction = "East";
        }
        else if (dir == 2){
            direction = "South";
        }
        else {
            direction = "West";
        }
        
        return direction;
    }
    
    // methods
    /**
     * Lets the rover move any number of spaces in the direction it's facing.
     * 
     * @param space How many spaces the rover will move
     */
    public void move(int space) {
        if (isAlive) {
            
            if (dir == 0) {
                y = y + space;
            }
            else if (dir == 1) {
                x = x  + space;
            }
            else if (dir == 2) {
                y = y  - space;
            }
            else if (dir == 3) {
                x = x  - space;
            }
            System.out.println(name + " moved " + space + " spaces in the " +
            getDirectionName(dir) + " direction and is at (" + x + ", " + y + "). ");
        }
    }
    
    /**
     * Rotates the rover to the right or left.
     * 
     * @param rotation How many times the rover will rotate to the left/right
     */
    public void rotate(int rotation) {
        if (isAlive) {
            if (rotation > 0){
                dir = dir + rotation;
                while (dir > 3){
                    dir = dir % 4;
                }
                System.out.println(name + " rotated to the right " + rotation +
                " time(s).");
            }
        
            else if (rotation < 0){
                dir = dir + rotation;
            
                while (dir < 0) {
                    dir += 4;
                }
                System.out.println(name + " rotated to the left " + Math.abs(rotation) +
                " time(s).");
            }
        }
    }
    
    /**
     * Teleports the rover to any location.
     * 
     * @param int x the x coordinate
     * @param int y the y coordinate
     */
    public void teleport(int x, int y) {
        if (isAlive) {
            x = x;
            y = y;
         
            System.out.println(name + " teleported to " + "(" + x + ", " + y + ") ");
        }
    }
    
    /**
     * Lets a rover kill another rover.
     * 
     * @param Rover other The name of the rover that is killed
     */
    public void kill(Rover other) {
        System.out.println(this.name + " shoots " + other.name + 
                           " with it's space lasers");
        System.out.println(other.name + " goes \" beep... beep...\" and dies.");
                            
    }
    
    public void hit(Rover other) {
        
    }
    
    /**
     * The current status of the rover that includes name, location, and direction. 
     */
    public void status() {
        System.out.println(name + " is at (" + x + ", " + y + ") " +
                           "and is facing " + getDirectionName(dir) + ".");
    }
}