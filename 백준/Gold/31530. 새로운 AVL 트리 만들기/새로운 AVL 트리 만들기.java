import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader와 StringBuilder를 이용하여 빠른 입출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수
        int testCase = Integer.parseInt(br.readLine().trim());

        while(testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int sCount = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            boolean allowNeg1 = false, allow0 = false, allow1 = false;
            for (int i = 0; i < sCount; i++) {
                int bal = Integer.parseInt(st.nextToken());
                if(bal == -1) allowNeg1 = true;
                else if(bal == 0) allow0 = true;
                else if(bal == 1) allow1 = true;
            }

            BigInteger[] dp = new BigInteger[h + 1];
            dp[0] = BigInteger.ONE;
            dp[1] = BigInteger.ONE;

            for (int i = 2; i <= h; i++) {
                dp[i] = BigInteger.ZERO;
                if (allow0) {
                    dp[i] = dp[i].add(dp[i - 1].multiply(dp[i - 1]));
                }
                if (allowNeg1) {
                    dp[i] = dp[i].add(dp[i - 1].multiply(dp[i - 2]));
                }
                if (allow1) {
                    dp[i] = dp[i].add(dp[i - 2].multiply(dp[i - 1]));
                }
            }
            sb.append(dp[h].toString()).append("\n");
        }

        System.out.print(sb);
    }
}