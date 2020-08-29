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
        int n = 20;
        String coloursPath = "src/input_files/colours.txt";
        String seqAlgPath = "src/input_files/sequence_algorithms.txt";

        Controller controller = new Controller(n, coloursPath, seqAlgPath);
        SequenceAlgorithm selectedSeqAlg = (SequenceAlgorithm) controller.chooseSequenceAlgorithm();
        selectedSeqAlg.run(controller.getNumOfFairyLights(), controller.getColours(), 0);
    }
}
