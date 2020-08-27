import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        // TODO: Pass in list of sequence algorithm names via command line arg
        ArrayList<SequenceAlgorithm> sequenceAlgorithmList = new ArrayList<>();
        sequenceAlgorithmList.add(new Sequence());
        sequenceAlgorithmList.add(new Colour());
        sequenceAlgorithmList.add(new Alternate());

        // TODO: Pass in numbOfFairyLights via command line arg
        Controller controller = new Controller(20, sequenceAlgorithmList);
        SequenceAlgorithm seqAlg = controller.chooseSequenceAlgorithm();
        System.out.println();
    }
}
