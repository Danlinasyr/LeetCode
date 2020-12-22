import java.util.Scanner;

// dp[i][j] is the max weight of i items with size of j

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        Scanner reader = new Scanner(System.in);
        
        int N = reader.nextInt();
        int V = reader.nextInt();
        
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            v[i] = reader.nextInt();
            w[i] = reader.nextInt();
        }
        
        reader.close();
        
        
        int[][] dp = new int[N + 1][V + 1];
        dp[0][0] = 0;
        
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                if (j >= v[i]) {
                    dp[i][j] = Math.max (dp[i - 1][j], dp[i-1][j - v[i]] + w[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i <= V; i++) {
            res = Math.max(res, dp[N][i]);
        }
        
        System.out.println(res);
        
    }
    
}