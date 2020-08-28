import java.util.List;

/**
 * @author David W. Arnold
 * @version 26/08/2020
 */
public abstract class SequenceAlgorithm
{
    abstract void run(int numOfFairyLights, List<String> colours);

    String getColour(int lightNum, List<String> colours)
    {
        if (lightNum % colours.size() == 0) {
            return colours.get(colours.size() - 1);
        } else {
            return colours.get((lightNum % colours.size()) - 1);
        }
    }
}
