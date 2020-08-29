/**
 * Main method.
 *
 * @author David W. Arnold
 * @version 26/08/2020
 */
public class Main
{
    public static void main(String[] args)
    {
        Controller controller = new Controller("input_files/colours.txt", "input_files/sequence_algorithms.txt");
        SequenceAlgorithm selectedSeqAlg = (SequenceAlgorithm) controller.chooseSequenceAlgorithm();
        selectedSeqAlg.run(controller.getNumOfFairyLights(), controller.getColours(), 0);
    }
}
