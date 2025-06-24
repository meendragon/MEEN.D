import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        board = new int[n+4][n+4];
        for (int i = 2; i < n + 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 2; j < n + 2; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Tornado tornado = new Tornado(n/2+2);
        tornado.sweep(n);
        bw.write(String.valueOf(calcOuterSand()));
        bw.flush();
        bw.close();
    }
    static long calcOuterSand() {
        long sum = 0;

        // 상단 + 하단
        for (int i = 0; i < n + 4; i++) {
            sum += (long) board[0][i];
            sum += (long) board[1][i];
            sum += (long) board[n + 2][i];
            sum += (long) board[n + 3][i];
        }

        // 좌 + 우
        for (int i = 2; i < n + 2; i++) {
            sum += (long) board[i][0];
            sum += (long) board[i][1];
            sum += (long) board[i][n + 2];
            sum += (long) board[i][n + 3];
        }

        return sum;
    }
}
class Tornado {
    int row;
    int col;
    int dir;

    Tornado(int start) {
        this.row = this.col = start;
        this.dir = 3;
    }

    public void sweep(int n){
        for(int i = 1;i<n;i++){
           sweepStep(i);
        }
        for(int i = 1;i<n;i++){
            move();
        }
    }

    private void sweepStep(int i){
        for(int j = 0;j<i;j++){
            move();
        }
        changeDir();
        for(int j = 0;j<i;j++){
            move();
        }
        changeDir();
    }

    private void move() {
        switch (dir) {
            case 0: row--; break; // ↑
            case 1: col++; break; // →
            case 2: row++; break; // ↓
            case 3: col--; break; // ←
        }
        spreadSand();
    }
    private void spreadSand() {
        double y = Main.board[row][col];

        // 비율 (← 방향 기준)
        double[][] ratio = {
                { -1,  0, 0.07 }, { -1, -1, 0.10 }, { -1,  1, 0.01 }, { -2,  0, 0.02 },
                {  1,  0, 0.07 }, {  1, -1, 0.10 }, {  1,  1, 0.01 }, {  2,  0, 0.02 },
                {  0, -2, 0.05 }
        };

        // 비율 퍼뜨리기
        for (double[] r : ratio) {
            int[] rotated = rotate((int) r[0], (int) r[1], (3 - dir + 4) % 4);
            int amount = (int)(y * r[2]);
            Main.board[row + rotated[0]][col + rotated[1]] += amount;
            Main.board[row][col] -= amount;
        }

        // 알파(남은 모래) 위치
        int[] alpha = rotate(0, -1, (3 - dir + 4) % 4);
        Main.board[row + alpha[0]][col + alpha[1]] += Main.board[row][col];
        Main.board[row][col] = 0;
    }

    // (dr, dc)를 dir 방향(0=↑,1=→,2=↓,3=←)에 맞춰 회전
    private int[] rotate(int dr, int dc, int dir) {
        for (int d = 0; d < dir; d++) {
            int tmp = dr;
            dr = -dc;
            dc = tmp;
        }
        return new int[] { dr, dc };
    }
    private void changeDir() {
        dir = (dir + 3) % 4; // 90도 반시계 회전
    }
}