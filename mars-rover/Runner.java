
/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner
{
    public static void main(String[] args) {
        Rover r1 = new Rover("Dwight", 2, 3, 0, 5, 2, 3);
        Rover r2 = new Rover("Jim", 4, 5, 2, 5, 4, 5);
        
        r1.move(5);
        r2.rotate(1);
        r1.charge(3);
        r1.hit(r2);
        r2.kill(r1);
        //r1.goHome();
        //r2.move(3);
        //r1.rotate(-3);
        //r1.move(4);
        //r2.rotate(-5);
        //r2.status();
    }
}
