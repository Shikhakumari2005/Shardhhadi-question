import java.util.*;

public class Main {

    static final int MOD = 1000000007;
    static int[][][] dp;

    public static int solve(int m, int n, int moves, int row, int col) {

        // Ball moved outside the grid
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }

        // No moves left
        if (moves == 0) {
            return 0;
        }

        if (dp[row][col][moves] != -1) {
            return dp[row][col][moves];
        }

        long ans = 0;

        ans += solve(m, n, moves - 1, row - 1, col); // Up
        ans += solve(m, n, moves - 1, row + 1, col); // Down
        ans += solve(m, n, moves - 1, row, col - 1); // Left
        ans += solve(m, n, moves - 1, row, col + 1); // Right

        dp[row][col][moves] = (int)(ans % MOD);

        return dp[row][col][moves];
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        dp = new int[m][n][maxMove + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(m, n, maxMove, startRow, startColumn);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input:
        // m n maxMove startRow startColumn
        int m = sc.nextInt();
        int n = sc.nextInt();
        int maxMove = sc.nextInt();
        int startRow = sc.nextInt();
        int startColumn = sc.nextInt();

        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));

        sc.close();
    }
} 
