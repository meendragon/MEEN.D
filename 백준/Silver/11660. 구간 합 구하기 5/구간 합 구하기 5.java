import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            int tempSum = 0;
            for (int j = 1; j <= N; j++) {
                int temp = scanner.nextInt();
                tempSum += temp;
                arr[i][j] = tempSum;
            }
        }
        for (int i = 0; i < M; i++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            int endX = scanner.nextInt();
            int endY = scanner.nextInt();
            int tempSum = 0;
            for (int j = startX; j <= endX; j++) {
                tempSum+=(arr[j][endY] - arr[j][startY-1]);
            }
            System.out.println(tempSum);
        }
    }
}
