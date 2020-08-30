import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Test class for Controller.
 *
 * @author David W. Arnold
 * @version 26/08/2020
 */
public class ControllerTest
{
    private int n;
    private String coloursPath;
    private String seqAlgPath;
    private ByteArrayInputStream in;
    private Controller controller;

    @Before
    public void setUp() throws Exception
    {
        // The number of fairy lights, by default.
        n = 20;
        // Relative path for list of colours, from the project root directory.
        coloursPath = "src/input_files/colours.txt";
        // Relative path for list of sequence algorithms, from the project root directory.
        seqAlgPath = "src/input_files/sequence_algorithms.txt";
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void getFairyLights()
    {
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        controller = new Controller(n, coloursPath, seqAlgPath);
        assertEquals("getFairyLights (1)", 20, controller.getNumOfFairyLights());

        in = new ByteArrayInputStream(("-1" + System.lineSeparator() + "1").getBytes());
        System.setIn(in);
        controller = new Controller(n, coloursPath, seqAlgPath);
        assertEquals("getFairyLights (2)", 20, controller.getNumOfFairyLights());

        in = new ByteArrayInputStream(("2" + System.lineSeparator() + "1").getBytes());
        System.setIn(in);
        controller = new Controller(n, coloursPath, seqAlgPath);
        assertEquals("getFairyLights (3)", 20, controller.getNumOfFairyLights());

        in = new ByteArrayInputStream(("0" + System.lineSeparator() + "10").getBytes());
        System.setIn(in);
        controller = new Controller(n, coloursPath, seqAlgPath);
        assertEquals("getFairyLights (4)", 10, controller.getNumOfFairyLights());

        in = new ByteArrayInputStream(("-1" + System.lineSeparator() + "0" + System.lineSeparator() + "13").getBytes());
        System.setIn(in);
        controller = new Controller(n, coloursPath, seqAlgPath);
        assertEquals("getFairyLights (5)", 13, controller.getNumOfFairyLights());

        in = new ByteArrayInputStream(("2" + System.lineSeparator() + "0" + System.lineSeparator() + "16").getBytes());
        System.setIn(in);
        controller = new Controller(n, coloursPath, seqAlgPath);
        assertEquals("getFairyLights (6)", 16, controller.getNumOfFairyLights());
    }

    @Test
    public void getColours()
    {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(coloursPath))) {
            while (br.ready()) {
                list.add(br.readLine());
            }
        } catch (IOException ignored) {
        }

        System.setIn(new ByteArrayInputStream("1".getBytes()));
        controller = new Controller(n, coloursPath, seqAlgPath);
        List<String> colours = controller.getColours();

        for (int i = 0; i < colours.size(); i++) {
            assertEquals("getColours (" + i + ")", list.get(i), colours.get(i));
        }
    }

    @Test
    public void getSequenceAlgorithms()
    {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(seqAlgPath))) {
            while (br.ready()) {
                try {
                    String sa = br.readLine();
                    String cappedSa = sa.substring(0, 1).toUpperCase() + sa.substring(1);
                    Class.forName(cappedSa);
                    list.add(cappedSa);
                } catch (ClassNotFoundException ignored) {
                }
            }
        } catch (IOException ignored) {
        }

        System.setIn(new ByteArrayInputStream("1".getBytes()));
        controller = new Controller(n, coloursPath, seqAlgPath);
        List<String> sequenceAlgorithms = controller.getSequenceAlgorithms();

        for (int i = 0; i < sequenceAlgorithms.size(); i++) {
            assertEquals("getSequenceAlgorithms (" + i + ")", list.get(i), sequenceAlgorithms.get(i));
        }
    }

    @Test
    public void chooseSequenceAlgorithm()
    {
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        controller = new Controller(n, coloursPath, seqAlgPath);

        for (int i = 1; i <= controller.getSequenceAlgorithms().size(); i++) {
            in = new ByteArrayInputStream(Integer.toString(i).getBytes());
            System.setIn(in);
            assertThat("chooseSequenceAlgorithm (" + i + ")", controller.chooseSequenceAlgorithm(), instanceOf(SequenceAlgorithm.class));
        }
    }
}