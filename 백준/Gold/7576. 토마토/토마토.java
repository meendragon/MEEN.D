import java.io.*;
import java.util.*;

public class Main {
    // 지도와 방문 여부 배열, 지도 크기, 단지 내 집의 수를 저장할 변수
    static int[][] box;
    static boolean[][] visited;
    static int n,m;
    static int count; // 현재 단지 내 집의 수

    // 상, 하, 좌, 우 이동을 위한 방향 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 익지 않은 토마토(값이 0)가 있으면
                    if (box[nx][ny] == 0) {
                        // 현재 토마토의 값 + 1로 갱신 (날짜 기록)
                        box[nx][ny] = box[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int days = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, box[i][j]);
            }
        }
        System.out.println(days - 1);

    }
}