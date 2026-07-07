import java.util.Scanner;

public class Main {

    public static long sumAndMultiply(int n) {
        String num = String.valueOf(n);

        StringBuilder sb = new StringBuilder();
        int sum = 0;

        // Collect non-zero digits and calculate their sum
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            if (ch != '0') {
                sb.append(ch);
                sum += ch - '0';
            }
        }

        // If there are no non-zero digits
        if (sb.length() == 0) {
            return 0;
        }

        long x = Long.parseLong(sb.toString());

        return x * sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(sumAndMultiply(n));

        sc.close();
    }
}