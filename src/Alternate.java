import java.util.List;

/**
 * Alternate sequencing algorithm.
 *
 * @author David W. Arnold
 * @version 26/08/2020
 */
public class Alternate extends SequenceAlgorithm
{
    @Override
    public void run(int numOfFairyLights, List<String> colours, int seconds)
    {
        String thisClassName = this.getClass().getName();
        runningSeqAlgMsg(thisClassName);
        while (true) {
            runHelper(numOfFairyLights, colours);
            repeatSeqAlgMsg(thisClassName);
        }
    }

    @Override
    protected void runHelper(int numOfFairyLights, List<String> colours)
    {
        SequenceAlgorithm sequence = new Sequence();
        sequence.run(numOfFairyLights, colours, 30);
        SequenceAlgorithm colour = new Colour();
        colour.run(numOfFairyLights, colours, 30);
    }
}
