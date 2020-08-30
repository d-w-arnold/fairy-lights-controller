import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test class for SequenceAlgorithm.
 *
 * @author David W. Arnold
 * @version 26/08/2020
 */
public class SequenceAlgorithmTest
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
    public void getColour()
    {
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        controller = new Controller(n, coloursPath, seqAlgPath);

        for (int i = 1; i <= controller.getSequenceAlgorithms().size(); i++) {
            in = new ByteArrayInputStream(Integer.toString(i).getBytes());
            System.setIn(in);
            SequenceAlgorithm selectedSeqAlg = controller.chooseSequenceAlgorithm();
            for (int j = 1; j <= controller.getNumOfFairyLights(); j++) {
                List<String> colours = controller.getColours();
                if (j % colours.size() == 0) {
                    assertEquals("getColour (" + j + ")", colours.get(colours.size() - 1), selectedSeqAlg.getColour(j, colours));
                } else {
                    assertEquals("getColour (" + j + ")", colours.get((j % colours.size()) - 1), selectedSeqAlg.getColour(j, colours));
                }
            }
        }
    }
}