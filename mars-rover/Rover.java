
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
    private int homex;
    private int homey;
    private int dir;
    private int health;
    private boolean isAlive;
    private int numPics;
    private int memory;
    private int energy;
    
    /**
     * Constructor for objects of class Rover
     */
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.numPics = 0;
        this.memory = 5;
        this.health = 5;
        this.isAlive = true;
        this.energy = 10;
    }
    
    /**
     * Constructor for objects of class Rover
     */
    public Rover(String name, int x, int y, int dir, int health, int homex, int homey)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.health = health;
        this.homex = x;
        this.homey = y;
        this.numPics = 0;
        this.memory = 5;
        this.health = 5;
        this.isAlive = true;
        this.energy = 10;
    }
    
    /**
     * Returns direction as a string instead of an integer. 
     * 
     * @param dir The direction of the rover as an integer
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
            
            if (space > energy) {
                System.out.println(name + " doesn't have enough energy to move " + space + " spaces.");
            }
            else if (energy > 0) {
                energy -= (1 * space);
            }
            else {
                isAlive = false;
                
                System.out.println(name + " has no more energy and can't move any more spaces");
            }
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
                
                if (energy > 0) {
                    energy -= (2 * rotation);
                }
                else if (energy == 0) {
                    isAlive = false;
                    
                    System.out.println(name + " has no more energy." + name + " can't rotate.");
                }
            }
        
            else if (rotation < 0){
                dir = dir + rotation;
            
                while (dir < 0) {
                    dir += 4;
                }
                
                System.out.println(name + " rotated to the left " + Math.abs(rotation) +
                    " time(s).");
       
                if (energy > 0) {
                    energy -= (2 * rotation);
                }
                else if (energy == 0) {
                    isAlive = false;
                    
                    System.out.println(name + " has no more energy." + name + " can't rotate.");
                }
            }
        }
    }
    
    /**
     * Teleports the rover to any location.
     * 
     * @param int x The x coordinate
     * @param int y The y coordinate
     */
    public void teleport(int x, int y) {
        if (isAlive) {
            x = x;
            y = y;
         
            System.out.println(name + " teleported to " + "(" + x + ", " + y + ") ");
            if (energy > 0) {
                energy -= 3;
            }
            else if (energy == 0) {
                isAlive = false;
                
                System.out.println(name + " has no more energy." + name + " can't teleport to " +
                    "(" + x + ", " + y + ").");
            }
        }
    }
    
    /**
     * Sends the rover back to its initial position.
     */
    public void goHome(){
        if (isAlive) {
            x = homex;
            y = homey;
            
            System.out.println(name + " went back home to " +
                "(" + x + ", " + y + ") ");
            if (energy > 0) {
                energy -= 3;
            }
            else if (energy == 0) {
                isAlive = false;
                
                System.out.println(name + " has no more energy." + name + " can't go home.");
            }
        }
    }
    
    /**
     * Lets a rover hit another rover at a random amount if it has enough power.
     * 
     * @param Rover other The rover that is getting hit
     */
    public void hit(Rover other) {
        double power = Math.random(); 
        
        if (isAlive) {
            if (power > 0.6) {
                if (health > 0 && energy > 0) {
                    health -= (5 * Math.random());
                    this.energy -= 4;
            
                    System.out.println(this.name + " slaps " + other.name + 
                        " with it's space arms and " + other.name +
                        "has " + health + " health left.");
                }    
                else if (energy == 0) {
                    isAlive = false;
                        
                    System.out.println(name + " has no more energy." + name + 
                        " can't hit another rover.");
                }
                
                else if (health == 0){
                    isAlive = false;
            
                    System.out.println(other.name + " is dead now.");
                }
            }
            
            else {
                System.out.println(this.name + " doesn't have enough power to hit " + other.name +
                    ".");
            }
        }
    }
    
    /**
     * Lets a rover kill another rover.
     * 
     * @param Rover other The name of the rover that is killed
     */
    public void kill(Rover other) {
        if (isAlive) {
            System.out.println(this.name + " shoots " + other.name + 
                " with it's space lasers and " + other.name + " is now dead.");
            System.out.println(other.name + " goes \" beep... beep...\" and dies.");  
            
            other.isAlive = false;
            if (energy > 0) {
                energy -= 5;
            }
            else if (energy == 0) {
                isAlive = false;
                
                System.out.println(name + " has no more energy.");
            }
        }
        else {
            System.out.println(other.name + " can't kill " + this.name + " he dead.");
        }
    }
    
    /**
     * Lets the rover take pictures.
     */
    public void takePicture() {
        if (isAlive) {
            if (numPics < memory){
                numPics += 1;
                
                System.out.println(name + " took " + numPics + " pictures at (" + x + ", " + y + ") " +
                    "and is facing " + getDirectionName(dir) + ".");
                if (energy > 0) {
                    energy -= (2 * numPics);
                }
                else if (energy == 0) {
                    isAlive = false;
                    
                    System.out.println(name + " has no more energy." + name + 
                        "can't take any more pictures");
                }
            }
            else {
                System.out.println(name + " can't take any more pictures ");
            }  
        }
    }
    
    /**
     * Lets rover send pictures back to earth.
     */
    public void transmitPictures() {
        if (isAlive && numPics > 0) {
            numPics = 0;
        
            System.out.println(name + " sent pictures back to Earth.");
            if (energy > 0) {
                energy -= 2;
            }
            else if (energy == 0) {
                isAlive = false;
                
                System.out.println(name + " has no more energy." + name + 
                    " can't send any pictures.");
            }
        }
        else {
            System.out.println(name + " needs to take pictures before sending them first.");
        }
    }
    
    /**
     * Lets a rover recharge when its energy is low. 
     * 
     * @param recharge The amount that recharges the rover's energy
     */
    public void charge(int recharge) {
        if (isAlive){
            if (recharge < 5 && recharge > 0) {
                if (energy >= 5) {
                    System.out.println(name + " doesn't need a recharge.");
               }
               else {
                   energy += recharge;
               
                   System.out.println(name + " recharged and its energy is now " + energy);
               }
            }
            else {
                System.out.println(name + " can't recharge that much.");
            }
        }
    }

    /**
     * The current status of the rover that includes name, location, direction, health, and energy. 
     */
    public void status() {
        if(isAlive) {
            System.out.println(name + " is at (" + x + ", " + y + ") " +
                ", has " + health + " health and " + 
                energy + " energy and is facing " + getDirectionName(dir) + ".");
        }
        else {
            System.out.println(name + " is dead.");
        }
    }
}