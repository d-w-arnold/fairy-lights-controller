import java.util.List;

/**
 * @author David W. Arnold
 * @version 26/08/2020
 */
public class Colour extends SequenceAlgorithm
{
    @Override
    public void run(int numOfFairyLights, List<String> colours)
    {
        System.out.println("\nRunning sequence algorithm: " + this.getClass().getName() + " ...\n");
        while (true) {
            for (int i = 1; i <= colours.size(); i++) {
                for (int j = 1; j <= numOfFairyLights; j++) {
                    if (j % colours.size() == i % colours.size()) {
                        System.out.println("Light " + j + " " + getColour(j, colours) + " on");
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                for (int j = 1; j <= numOfFairyLights; j++) {
                    if (j % colours.size() == i % colours.size()) {
                        System.out.println("Light " + j + " " + getColour(j, colours) + " off");
                    }
                }
            }
            System.out.println("\n(Algorithm repeating ...)\n");
        }
    }
}
