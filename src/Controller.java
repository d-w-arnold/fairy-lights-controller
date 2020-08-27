import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author David W. Arnold
 * @version 26/08/2020
 */
public class Controller
{
    private int numOfFairyLights;
    private ArrayList<SequenceAlgorithm> sequenceAlgorithms;

    public Controller(int numOfFairyLights, ArrayList<SequenceAlgorithm> sequenceAlgorithms)
    {
        this.numOfFairyLights = numOfFairyLights;
        this.sequenceAlgorithms = sequenceAlgorithms;
        System.out.println("\n--- Welcome to this Fairy Light Controller ---\n");
    }

    private void chooseSequenceAlgorithmMsg()
    {
        System.out.println("Please choose a sequencing algorithm:\n\n(List of possible choices:)");
        for (int i = 0; i < sequenceAlgorithms.size(); i++) {
            System.out.println((i + 1) + ") " + sequenceAlgorithms.get(i).getClass().getName());
        }
    }

    public SequenceAlgorithm chooseSequenceAlgorithm()
    {
        chooseSequenceAlgorithmMsg();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int selection = 0;
        try {
            while (true) {
                System.out.println("\nType here the number corresponding to a sequencing algorithm:");
                selection = Integer.parseInt(br.readLine());
                if (1 <= selection && selection <= sequenceAlgorithms.size()) {
                    break;
                } else {
                    System.out.println("\n** Please try again - choose a valid number **\n");
                    chooseSequenceAlgorithmMsg();
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return sequenceAlgorithms.get(selection - 1);
    }
}
