import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static boolean working = true;
    static int rowS;
    static int colS;
    static int dirS;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] room = new int[n][m];
        st = new StringTokenizer(br.readLine());
        rowS = Integer.parseInt(st.nextToken());
        colS = Integer.parseInt(st.nextToken());
        dirS = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Robot robot = new Robot();
        while (working) {
            robot.clean(room, rowS, colS, dirS);
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    static class Robot {
        int[] rowMove = {-1, 0, 1, 0};
        int[] colMove = {0, 1, 0, -1};

        Robot() {
        }

        void clean(int[][] room, int row, int col, int dir) {
            if (room[row][col] == 0) {
                room[row][col] = 2;
                count++;
                int turnCount = 0;
                boolean dirtyAround = false;
                while (!dirtyAround) {
                    if (row + rowMove[dir] >= n || row + rowMove[dir] < 0 || col + colMove[dir] >= m || col + colMove[dir] < 0) {
                        dirS = dir = dir - 1;
                        turnCount++;
                        if (dir - 1 < 0) {
                            dir = dirS = 3;
                        }
                        if (turnCount == 4) {
                            break;
                        }
                    } else {
                        dirS = dir = dir - 1;
                        turnCount++;
                        if (dir  < 0) {
                            dir = dirS = 3;
                        }
                        if (room[row + rowMove[dir]][col + colMove[dir]] == 0) {
                            dirtyAround = true;
                        }
                        if (turnCount == 4) {
                            break;
                        }
                    }

                }
                if (turnCount == 4) {
                    int temp = dir;
                    if(!dirtyAround){
                        dirS = dir = dir-2;
                        if(dir<0){dirS = dir = dir+4;}
                    }
                    if (room[row + rowMove[dir]][col + colMove[dir]] != 1) {//벽이아니라면 돌아가서 다시시작
                        rowS = row + rowMove[dir];
                        colS = col + colMove[dir];
                        dirS = dir =  temp;
                        return;
                    } else {
                        working = false;
                        return;
                    }
                } else {
                    rowS = row + rowMove[dir];
                    colS = col + colMove[dir];
                    return;
                }
            } else {

                //후진해서 온경우겟네
                int turnCount = 0;
                boolean dirtyAround = false;
                while (!dirtyAround) {
                    if (row + rowMove[dir] >= n || row + rowMove[dir] < 0 || col + colMove[dir] >= m || col + colMove[dir] < 0) {
                        dirS = dir = dir - 1;
                        turnCount++;
                        if (dir - 1 < 0) {
                            dir = dirS = 3;
                        }
                        if (turnCount == 4) {
                            break;
                        }
                    } else {
                        dirS = dir = dir - 1;
                        turnCount++;
                        if (dir  < 0) {
                            dir = dirS = 3;
                        }
                        if (room[row + rowMove[dir]][col + colMove[dir]] == 0) {
                            dirtyAround = true;
                        }
                        if (turnCount == 4) {
                            break;
                        }
                    }

                }
                if (turnCount == 4) {
                    int temp = dir;
                    if(!dirtyAround){
                        dirS = dir = dir-2;
                        if(dir<0){dirS = dir = dir+4;}
                    }
                    if (room[row + rowMove[dir]][col + colMove[dir]] != 1) {//벽이아니라면 돌아가서 다시시작
                        rowS = row + rowMove[dir];
                        colS = col + colMove[dir];
                        dirS = dir =  temp;
                        return;
                    } else {
                        working = false;
                        return;
                    }
                } else {
                    rowS = row + rowMove[dir];
                    colS = col + colMove[dir];
                    return;
                }

            }
        }
    }
}

