import java.util.List;

/**
 * 'Colour' sequencing algorithm.
 * <p>
 * All of the red lights are turned on for 1 second,
 * then all the green for 1 second then all the white for 1 second.
 *
 * @author David W. Arnold
 * @version 26/08/2020
 */
public class Colour extends SequenceAlgorithm
{
    @Override
    public void run(int numOfFairyLights, List<String> colours, int seconds)
    {
        runLogic(numOfFairyLights, colours, seconds);
    }

    @Override
    protected void runHelper(int numOfFairyLights, List<String> colours)
    {
        for (int i = 1; i <= colours.size(); i++) {
            for (int j = 1; j <= numOfFairyLights; j++) {
                if (j % colours.size() == i % colours.size()) {
                    printOnMsg(j, colours);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 1; j <= numOfFairyLights; j++) {
                if (j % colours.size() == i % colours.size()) {
                    printOffMsg(j, colours);
                }
            }
        }
    }

    @Override
    protected String getDescription()
    {
        return "All of the red lights are turned on for 1 second, then all the green for 1 second then all the white for 1 second.";
    }
}
