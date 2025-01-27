import java.util.*;

public class a {
    public static int maximizeAlternatingStringWorth(String binaryString, int[] worths) {
        int n = binaryString.length();
        int totalWorthRemoved = 0; // To calculate the total worth of removed characters
        char lastChar = ' '; // Keep track of the last character in the alternating sequence
        int lastWorth = 0; // Keep track of the worth of the last character in the sequence

        for (int i = 0; i < n; i++) {
            char currentChar = binaryString.charAt(i);
            int currentWorth = worths[i];

            if (lastChar == ' ' || lastChar != currentChar) {
                // Add the current character to the sequence
                lastChar = currentChar;
                lastWorth = currentWorth;
            } else {
                // Conflict: decide whether to keep or remove
                if (lastWorth < currentWorth) {
                    // Replace the last character
                    totalWorthRemoved += lastWorth;
                    lastChar = currentChar;
                    lastWorth = currentWorth;
                } else {
                    // Remove the current character
                    totalWorthRemoved += currentWorth;
                }
            }
        }

        return totalWorthRemoved;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the binary string
        String binaryString = sc.nextLine();

        // Read the worths as space-separated integers
        int n = binaryString.length();
        int[] worths = new int[n];
        for (int i = 0; i < n; i++) {
            worths[i] = sc.nextInt();
        }

        // Calculate the result
        int result = maximizeAlternatingStringWorth(binaryString, worths);

        // Print the result without extra spaces or newlines
        System.out.print(result);

        sc.close();
    }
}
