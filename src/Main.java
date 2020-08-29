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
        // The number of fairy lights, by default.
        int n = 20;
        // Relative path for list of colours, from the project root directory.
        String coloursPath = "src/input_files/colours.txt";
        // Relative path for list of sequence algorithms, from the project root directory.
        String seqAlgPath = "src/input_files/sequence_algorithms.txt";

        Controller controller = new Controller(n, coloursPath, seqAlgPath);
        SequenceAlgorithm selectedSeqAlg = (SequenceAlgorithm) controller.chooseSequenceAlgorithm();
        selectedSeqAlg.run(controller.getNumOfFairyLights(), controller.getColours(), 0);
    }
}
