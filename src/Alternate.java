import java.util.List;

/**
 * @author David W. Arnold
 * @version 26/08/2020
 */
public class Alternate implements SequenceAlgorithm
{
    @Override
    public void run(int numOfFairyLights, List<String> colours)
    {
        System.out.println("Running " + this.getClass().getName() + " sequence ...");
    }
}
