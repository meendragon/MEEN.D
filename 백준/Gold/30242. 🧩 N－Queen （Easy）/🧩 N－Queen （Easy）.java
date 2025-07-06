import java.io.*;
import java.util.*;

public class Main {
    static boolean[] col;
    static boolean[] up;
    static boolean[] down;
    static boolean[][] board;
    static int n;
    static boolean found = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = new boolean[n];
        up = new boolean[2 * n - 1];
        down = new boolean[2 * n - 1];
        board = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp != 0) {
                temp--; // 0-based
                board[i][temp] = true;
                col[temp] = true;
                up[i + temp] = true;
                down[i - temp + n - 1] = true;
            }
        }

        dfs(0);
        if(!found) System.out.println(-1);
    }

    static void dfs(int r) {
        if(found) return;
        if (r == n) {
            // 퀸의 열 출력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        System.out.print((j+1) + " ");
                        break;
                    }
                }
            }
            System.out.println();
            found = true;
            return;
        }

        // 이미 놓인 퀸이 있는 경우는 skip
        for (int c = 0; c < n; c++) {
            if (board[r][c]) {
                dfs(r + 1);
                return;
            }
        }

        // 퀸 놓을 자리 탐색
        for (int c = 0; c < n; c++) {
            if (!col[c] && !up[r + c] && !down[r - c + n - 1]) {
                board[r][c] = true;
                col[c] = up[r + c] = down[r - c + n - 1] = true;

                dfs(r + 1);

                // 백트래킹
                board[r][c] = false;
                col[c] = up[r + c] = down[r - c + n - 1] = false;
            }
        }
    }
}