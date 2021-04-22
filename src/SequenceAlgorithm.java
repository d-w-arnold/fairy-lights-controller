import java.util.List;

/**
 * An abstract class for a fairy light sequence algorithm.
 *
 * @author David W. Arnold
 * @version 26/08/2020
 */
public abstract class SequenceAlgorithm
{
    /**
     * Run a sequence algorithm.
     *
     * @param numOfFairyLights The number of fairy lights known by the controller.
     * @param colours          List of colours.
     * @param seconds          How many seconds the sequence algorithm will run for,
     *                         if less than or equal to 0, the sequence algorithm keeps repeating.
     */
    abstract public void run(int numOfFairyLights, List<String> colours, int seconds);

    /**
     * Logic unique to each sequence algorithm.
     *
     * @param numOfFairyLights The number of fairy lights known by the controller.
     * @param colours          List of colours.
     */
    abstract protected void runHelper(int numOfFairyLights, List<String> colours);

    /**
     * Get a description of how a sequence algorithm works.
     *
     * @return A string describing how a sequence algorithm works.
     */
    abstract protected String getDescription();

    /**
     * Logic to decide whether a sequence algorithm runs for a specified
     * number of seconds, or keeps repeating.
     *
     * @param numOfFairyLights The number of fairy lights known by the controller.
     * @param colours          List of colours.
     * @param seconds          How many seconds the sequence algorithm will run for,
     *                         if less than or equal to 0, the sequence algorithm keeps repeating.
     */
    protected void runLogic(int numOfFairyLights, List<String> colours, int seconds)
    {
        String thisClassName = this.getClass().getName();
        runningSeqAlgMsg(thisClassName);
        if (seconds <= 0) {
            while (true) {
                runHelper(numOfFairyLights, colours);
                repeatSeqAlgMsg(thisClassName);
            }
        } else {
            long start = System.currentTimeMillis();
            long end = start + (seconds * 1000L);
            while (System.currentTimeMillis() < end) {
                runHelper(numOfFairyLights, colours);
                repeatSeqAlgMsg(thisClassName);
            }
        }
    }

    /**
     * Get the colour of a fairy light, based on its position in the length of fairy lights.
     *
     * @param lightNum The number of a fairy light.
     * @param colours  List of colours.
     * @return A string denoting the colour of a fairy light.
     */
    protected String getColour(int lightNum, List<String> colours)
    {
        if (lightNum % colours.size() == 0) {
            return colours.get(colours.size() - 1);
        } else {
            return colours.get((lightNum % colours.size()) - 1);
        }
    }

    protected void runningSeqAlgMsg(String thisClassName)
    {
        System.out.println("\n(Running sequence algorithm: " + thisClassName + " ...)\n");
    }

    protected void repeatSeqAlgMsg(String thisClassName)
    {
        System.out.println("\n(Repeating sequence algorithm: " + thisClassName + " ...)\n");
    }

    protected void printOnMsg(int i, List<String> colours)
    {
        System.out.println("Light " + i + " " + getColour(i, colours) + " on");
    }

    protected void printOffMsg(int i, List<String> colours)
    {
        System.out.println("Light " + i + " " + getColour(i, colours) + " off");
    }
}
