import java.util.*;

public class Main {

    public static String convert(String s, int numRows) {

        // If only one row or rows >= string length, no zigzag is needed
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Create StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse each character
        for (char ch : s.toCharArray()) {

            rows[currentRow].append(ch);

            // Change direction at first or last row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to next row
            if (goingDown) {
                currentRow++;
            } else {
                currentRow--;
            }
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            result.append(rows[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String s = sc.nextLine();

        System.out.print("Enter Number of Rows: ");
        int numRows = sc.nextInt();

        String ans = convert(s, numRows);

        System.out.println("Zigzag Conversion: " + ans);

        sc.close();
    }
}