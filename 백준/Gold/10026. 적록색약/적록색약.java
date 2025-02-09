import java.io.*;
import java.util.*;

public class Main {
    static int[][] box;
    static boolean[][] visited;
    static int n, m;
    // 상하좌우 4방향
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 줄에 행의 개수 n와 열의 개수 m이 주어진다고 가정합니다.
        n = Integer.parseInt(st.nextToken());

        box = new int[n][n];
        visited = new boolean[n][n];

        // n개의 줄에 걸쳐 m개의 토큰("R", "G", "B")을 입력받음
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                switch (line.charAt(j)) {
                    case 'R':
                        box[i][j] = 2;
                        break;
                    case 'G':
                        box[i][j] = 1;
                        break;
                    case 'B':
                        box[i][j] = 0;
                        break;
                }
            }
        }
        bfs();
        visited = new boolean[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                box[i][j] = box[i][j] > 0 ? 1: 0;
            }
        }
        bfsRG();
    }

    private static void bfs() {
        int count = 0;  // 연결된 영역의 개수를 센다.
        Queue<int[]> queue = new ArrayDeque<>();

        // 전체 격자를 순회하며 아직 방문하지 않은 칸에서 BFS 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int currentColor = box[i][j];
                    // 시작점 방문처리 후 큐에 추가
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    count++;  // 새로운 영역 발견

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int curX = current[0];
                        int curY = current[1];

                        // 상하좌우 4방향 확인
                        for (int d = 0; d < 4; d++) {
                            int nx = curX + dx[d];
                            int ny = curY + dy[d];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                // 아직 방문하지 않았고, 색이 같은 경우
                                if (!visited[nx][ny] && box[nx][ny] == currentColor) {
                                    visited[nx][ny] = true;
                                    queue.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        // 최종적으로 연결된 영역의 개수를 출력
        System.out.print(count + " ");
    }
    private static void bfsRG() {
        int count = 0;  // 연결된 영역의 개수를 센다.
        Queue<int[]> queue = new ArrayDeque<>();

        // 전체 격자를 순회하며 아직 방문하지 않은 칸에서 BFS 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int currentColor = box[i][j];
                    // 시작점 방문처리 후 큐에 추가
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    count++;  // 새로운 영역 발견

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int curX = current[0];
                        int curY = current[1];

                        // 상하좌우 4방향 확인
                        for (int d = 0; d < 4; d++) {
                            int nx = curX + dx[d];
                            int ny = curY + dy[d];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                // 아직 방문하지 않았고, 색이 같은 경우
                                if (!visited[nx][ny] && box[nx][ny] == currentColor) {
                                    visited[nx][ny] = true;
                                    queue.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        // 최종적으로 연결된 영역의 개수를 출력
        System.out.println(count);
    }
}