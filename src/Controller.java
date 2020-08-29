import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * A controller for a length of fairy lights.
 *
 * @author David W. Arnold
 * @version 26/08/2020
 */
public class Controller
{
    private final int numOfFairyLights;
    private final List<String> colours;
    private final List<String> sequenceAlgorithms;

    public Controller(String colours, String sequenceAlgorithms)
    {
        System.out.println("\n--- Welcome to this Fairy Light Controller ---");
        this.numOfFairyLights = getFairyLights();
        this.colours = fileToList(colours);
        this.sequenceAlgorithms = validateSequenceAlgorithms(fileToList(sequenceAlgorithms));
    }

    private static int getFairyLights()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfFairyLights = 0;
        try {
            while (true) {
                System.out.println("\nHow long is the length of fairy lights: (e.g. 20)");
                numOfFairyLights = Integer.parseInt(br.readLine());
                if (0 < numOfFairyLights) {
                    break;
                } else {
                    System.out.println("\n** Please choose a positive number of fairy lights **");
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return numOfFairyLights;
    }

    public int getNumOfFairyLights()
    {
        return numOfFairyLights;
    }

    public List<String> getColours()
    {
        return colours;
    }

    private List<String> fileToList(String path)
    {
        List<String> colours = new ArrayList<>();
        try (BufferedReader brColours = new BufferedReader(new FileReader(path))) {
            while (brColours.ready()) {
                colours.add(brColours.readLine());
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println("\n** Read in file contents: " + path + " **");
        return colours;
    }

    private List<String> validateSequenceAlgorithms(List<String> list)
    {
        List<String> newList = new ArrayList<>();
        for (String sa : list) {
            try {
                String cappedSa = sa.substring(0, 1).toUpperCase() + sa.substring(1);
                Class.forName(cappedSa);
                newList.add(cappedSa);
            } catch (ClassNotFoundException ignored) {
            }
        }
        return newList;
    }

    public Object chooseSequenceAlgorithm()
    {
        chooseSeqAlgMsg();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int selection = 0;
        try {
            while (true) {
                System.out.println("\nType here the number corresponding to a sequencing algorithm:");
                selection = Integer.parseInt(br.readLine());
                if (1 <= selection && selection <= sequenceAlgorithms.size()) {
                    break;
                } else {
                    System.out.println("\n** Please choose a valid number **");
                    chooseSeqAlgMsg();
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        Object instanceOfMyClass = null;
        try {
            instanceOfMyClass = Class.forName(sequenceAlgorithms.get(selection - 1)).getConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            System.out.println(e);
        }
        return instanceOfMyClass;
    }

    private void chooseSeqAlgMsg()
    {
        System.out.println("\nPlease choose a sequencing algorithm:\n\n(List of possible choices:)");
        for (int i = 0; i < sequenceAlgorithms.size(); i++) {
            System.out.println((i + 1) + ") " + sequenceAlgorithms.get(i));
        }
    }
}
