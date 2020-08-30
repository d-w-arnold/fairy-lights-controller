# Fairy Lights Controller - Gattaca - Java Candidate Exercise

## How to run program:

Run the `main()` method in `src/Main.java`.

When the program is run, the user will firstly be prompted whether the controller should run with 20 fairy lights.

If 'Yes', the user will get to choose the sequence algorithm to be run by the controller.

If 'No', the user will be prompted to input an alternative number of fairy lights, and then get to choose a sequence algorithm. 

## Add a new light colour or change the light order:

See `input_files/colours.txt`.
 
To add a new light colour, add a new colour on a new line of this file.
 
To change the light order, reorder the list of colours in this file.

## Add a new controller algorithm:

1) In the `src` directory, make a new Java Class which extends the 'SequenceAlgorithm' abstract Java class.

2) Add the name of the new sequence algorithm Java class to `input_files/sequence_algorithms.txt`, on a new line.

## Unit testing:

There are two JUnit 4 test classes:

1) `src/ControllerTest.java` for unit testing features of the `src/Controller.java` class.

2) `src/SequenceAlgorithmTest.java` for unit testing features of the `src/SequenceAlgorithm.java` class.
