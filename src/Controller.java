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

    public Controller(int numOfFairyLights, String colours, String sequenceAlgorithms)
    {
        System.out.println("\n--- Welcome to this Fairy Light Controller ---");
        this.numOfFairyLights = getFairyLights(numOfFairyLights);
        this.colours = fileToList(colours);
        this.sequenceAlgorithms = validateSequenceAlgorithms(fileToList(sequenceAlgorithms));
    }

    private static int getFairyLights(int numOfFairyLights)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int option = 0;
        try {
            while (true) {
                System.out.println("\nRun the Fairy Light Controller with " + numOfFairyLights + " fairy lights? (1 - Yes, 0 - No)");
                option = Integer.parseInt(br.readLine());
                if (0 <= option && option <= 1) {
                    break;
                } else {
                    System.out.println("\n** Please choose a valid option **");
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        if (option == 0) {
            try {
                while (true) {
                    System.out.println("\nHow many fairy lights should the Fairy Light Controller account for? (e.g. " + numOfFairyLights + ")");
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

    public List<String> getSequenceAlgorithms()
    {
        return sequenceAlgorithms;
    }

    private List<String> fileToList(String path)
    {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                list.add(br.readLine());
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println("\n** Read in file contents: " + path + " **");
        return list;
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

    public SequenceAlgorithm chooseSequenceAlgorithm()
    {
        List<SequenceAlgorithm> seqAlgObjects = namesToSequenceAlgorithms(sequenceAlgorithms);
        chooseSeqAlgMsg(seqAlgObjects);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int selection = 0;
        try {
            while (true) {
                System.out.println("\nType here the number corresponding to a sequencing algorithm:");
                selection = Integer.parseInt(br.readLine());
                if (1 <= selection && selection <= seqAlgObjects.size()) {
                    break;
                } else {
                    System.out.println("\n** Please choose a valid number **");
                    chooseSeqAlgMsg(seqAlgObjects);
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return seqAlgObjects.get(selection - 1);
    }

    private List<SequenceAlgorithm> namesToSequenceAlgorithms(List<String> names)
    {
        List<SequenceAlgorithm> sequenceAlgorithms = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            try {
                SequenceAlgorithm instanceOfMyClass = (SequenceAlgorithm) Class.forName(names.get(i)).getConstructor().newInstance();
                sequenceAlgorithms.add(instanceOfMyClass);
            } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                System.out.println(e);
            }
        }
        return sequenceAlgorithms;
    }

    private void chooseSeqAlgMsg(List<SequenceAlgorithm> seqAlgObjects)
    {
        System.out.println("\nPlease choose a sequencing algorithm:\n\n(List of possible choices:)");
        for (int i = 0; i < sequenceAlgorithms.size(); i++) {
            System.out.println((i + 1) + ") " + sequenceAlgorithms.get(i) + " - " + seqAlgObjects.get(i).getDescription());
        }
    }
}
