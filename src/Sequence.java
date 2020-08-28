import java.util.List;

/**
 * @author David W. Arnold
 * @version 26/08/2020
 */
public class Sequence extends SequenceAlgorithm
{
    @Override
    public void run(int numOfFairyLights, List<String> colours)
    {
        System.out.println("\nRunning sequence algorithm: " + this.getClass().getName() + " ...\n");
        while (true) {
            for (int i = 1; i <= numOfFairyLights; i++) {
                System.out.println("Light " + i + " " + getColour(i, colours) + " on");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println("Light " + i + " " + getColour(i, colours) + " off");
            }
            System.out.println("\n(Algorithm repeating ...)\n");
        }
    }
}
