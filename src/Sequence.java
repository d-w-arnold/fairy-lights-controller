import java.util.List;

/**
 * Sequence sequencing algorithm.
 *
 * @author David W. Arnold
 * @version 26/08/2020
 */
public class Sequence extends SequenceAlgorithm
{
    @Override
    public void run(int numOfFairyLights, List<String> colours, int seconds)
    {
        runLogic(numOfFairyLights, colours, seconds);
    }

    @Override
    protected void runHelper(int numOfFairyLights, List<String> colours)
    {
        for (int i = 1; i <= numOfFairyLights; i++) {
            printOnMsg(i, colours);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            printOffMsg(i, colours);
        }
    }
}
