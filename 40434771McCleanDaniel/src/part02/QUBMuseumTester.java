package part02;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import part01.Artifact;
import part01.Exhibit;
import part01.QUBMuseum;

public class QUBMuseumTester {

    private static final Random random = new Random();

    public static void main(String[] args) {
        try {
            Method resetArtifact = Artifact.class.getDeclaredMethod("reset");
            resetArtifact.setAccessible(true); // Bypass Java access control
            resetArtifact.invoke(null);

            Method resetExhibit = Exhibit.class.getDeclaredMethod("reset");
            resetExhibit.setAccessible(true); // Bypass Java access control
            resetExhibit.invoke(null);

            System.out.println("Class in Test: QUBMuseum");
            boolean allPassed = true;
            for (int i = 0; i < 1000; i++) {
                String randomInput = "";
                PrintStream stdout = System.out;
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                System.setOut(new PrintStream(result));

                PrintStream sterr = System.err;
                ByteArrayOutputStream err = new ByteArrayOutputStream();
                System.setErr(new PrintStream(err));

                try {
                    // Generate random input and pass it to the QUBMuseum application
                    randomInput = generateRandomInput(1_000_000); // Generate 1 million characters of random input
                    InputStream inputStream = new ByteArrayInputStream(randomInput.getBytes());

                    // Redirect System.in to the random input stream
                    System.setIn(inputStream);

                    // Run the QUBMuseum application
                    QUBMuseum.main(new String[] {});

                    System.setOut(stdout);
                    System.setErr(sterr);

                    System.out.println("\tFuzz test Iteration " + (i + 1) + " Passed");
                } catch (Exception e) {
                    System.setOut(stdout);
                    System.setErr(sterr);
                    if (e.getMessage() != null && e.getMessage().equals("No line found")) {
                        System.out.println("\tFuzz test Iteration " + (i + 1) + " Passed");
                    } else {
                        // For unexpected crashes, print the stack trace
                        System.err.println("The program crashed with an exception:");
                        e.printStackTrace();
                        // Write inputs and the output from QUBMuseum to test files in the event of unexpected crashes
                        writeFile("input_sequence.txt", randomInput);
                        writeFile("debug_Output.txt", result.toString());
                        allPassed = false;
                        break;
                    }
                } finally {
                    System.setOut(stdout);
                    System.setErr(sterr);
                    resetArtifact.invoke(null);
                    resetExhibit.invoke(null);
                }
            }

            System.out.println("All Iterations Passed: " + allPassed);
        } catch (Exception e) {

        }
    }

    /**
     * Generates a random string of input for testing.
     * 
     * Created with assitance from ChatGPT-4o
     * 24/11/2024
     * 
     * @param length The length of the input string to generate.
     * @return A random string representing fuzzed user input.
     */
    private static String generateRandomInput(long length) {
        StringBuilder inputBuilder = new StringBuilder();

        // Generate a random sequence of characters and simulate random newlines
        for (long i = 0; i < length; i++) {
            int randChar = random.nextInt(95) + 32; // Random printable ASCII characters (32 to 126)

            inputBuilder.append((char) randChar);

            // Occasionally simulate pressing Enter by adding a newline
            if (random.nextInt(10) == 0) {
                inputBuilder.append("\n");
            }
        }

        // Return the generated input as a string
        return inputBuilder.toString();
    }

    /**
     * Copied from Canvas Example Code
     * Fun.java
     * @param filename
     * @param contents
     */
    public static void writeFile(String filename, String contents) {
        // Try-with-resources to ensure the BufferedWriter is closed properly
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filename))) {
            // Write the content of StringBuilder to the file
            bw.write(contents);
            System.out.println("File written successfully to " + filename);
        } catch (IOException e) {
            // Handle any I/O exceptions
            System.err.format("IOException: %s%n", e);
        }
    }
}
