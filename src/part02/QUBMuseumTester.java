package part02;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import part01.QUBMuseum;

public class QUBMuseumTester {

    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Starting QUBMuseum single long-input fuzz test...");

        try {
            // Generate random input and pass it to the QUBMuseum application
            String randomInput = generateRandomInput(1_000_000_000); // Generate 1 billion characters of random input
            InputStream inputStream = new ByteArrayInputStream(randomInput.getBytes());

            // Redirect System.in to the random input stream
            System.setIn(inputStream);

            // Run the QUBMuseum application
            QUBMuseum.main(new String[]{});
        } catch (Exception e) {
            // Handle exceptions
            if (e.getMessage() != null && e.getMessage().equals("No line found")) {
                System.out.println("End of input stream reached (expected).");
            } else {
                // For unexpected crashes, print the stack trace
                System.err.println("The program crashed with an exception:");
                e.printStackTrace();
            }
        }

        System.out.println("Test completed. Check the output logs for any errors or crashes.");
    }

    /**
     * Generates a random string of input for testing.
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
}
