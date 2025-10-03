import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 0! = 1 예외 처리
        if (N == 0) {
            System.out.println(1);
            return;
        }

        // 분할 정복 함수 호출
        BigInteger result = factorial(1, N);

        // 출력을 빠르게
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result.toString());
        bw.newLine();
        bw.flush();
    }

    /**
     * 분할 정복(Divide and Conquer) 방식으로 [start, end] 범위의 곱을 계산하는 함수.
     */
    private static BigInteger factorial(int start, int end) {
        // 1. 기본 단계 (Base Case)
        if (start > end) {
            return BigInteger.ONE;
        }
        if (start == end) {
            return BigInteger.valueOf(start);
        }
        
        // 2. 분할 (Divide)
        int mid = start + (end - start) / 2;
        
        // 3. 정복 (Conquer) 및 결합 (Combine)
        // [start, mid] 범위의 곱 * [mid + 1, end] 범위의 곱
        BigInteger left = factorial(start, mid);
        BigInteger right = factorial(mid + 1, end);
        
        return left.multiply(right);
    }
}