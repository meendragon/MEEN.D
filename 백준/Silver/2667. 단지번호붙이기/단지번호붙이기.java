import java.io.*;
import java.util.*;

public class Main {
    // 지도와 방문 여부 배열, 지도 크기, 단지 내 집의 수를 저장할 변수
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int count; // 현재 단지 내 집의 수

    // 상, 하, 좌, 우 이동을 위한 방향 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 단지별 집의 수를 저장할 리스트
        ArrayList<Integer> clusters = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;  // 새 단지 시작 시 집의 수 초기화
                    dfs(i, j);
                    clusters.add(count);
                }
            }
        }

        Collections.sort(clusters);

        System.out.println(clusters.size());
        for (int num : clusters) {
            System.out.println(num);
        }
    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}