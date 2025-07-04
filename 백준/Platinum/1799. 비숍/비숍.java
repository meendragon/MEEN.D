import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[] leftDiag;
    static boolean[] rightDiag;
    static int maxBlack = 0, maxWhite = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 대각선 체크 배열 초기화 (최대 2n-1 개)
        leftDiag = new boolean[2 * n];
        rightDiag = new boolean[2 * n];

        // 검정 칸만 탐색
        dfs(0, 0, 0);  // start from (0,0), black tile
        maxBlack = max;

        max = 0;

        // 흰 칸만 탐색
        dfs(0, 1, 0);  // start from (0,1), white tile
        maxWhite = max;

        System.out.println(maxBlack + maxWhite);
    }

    static int max = 0;

    static void dfs(int row, int col, int count) {
        if (col >= n) {
            row++;
            // 색깔 유지하며 다음 줄로 이동
            col = (col % 2 == 0) ? 1 : 0;
        }

        if (row >= n) {
            max = Math.max(max, count);
            return;
        }

        if (board[row][col] == 1 && !leftDiag[row - col + n - 1] && !rightDiag[row + col]) {
            leftDiag[row - col + n - 1] = true;
            rightDiag[row + col] = true;
            dfs(row, col + 2, count + 1);
            leftDiag[row - col + n - 1] = false;
            rightDiag[row + col] = false;
        }

        // 현재 칸에 비숍 안 놓는 경우
        dfs(row, col + 2, count);
    }
}