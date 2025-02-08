import java.io.*;
import java.util.*;

public class Main {
    static int len;
    // 나이트의 8가지 이동 방향 (행, 열의 변화)
    static int[] dR = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dC = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        // 빠른 입출력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < testCase; t++) {
            len = Integer.parseInt(br.readLine().trim());

            // 시작 좌표 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());

            // 도착 좌표 입력
            st = new StringTokenizer(br.readLine());
            int targetR = Integer.parseInt(st.nextToken());
            int targetC = Integer.parseInt(st.nextToken());

            // BFS를 통해 최소 이동 횟수 계산 후 출력
            System.out.println(bfs(startR, startC, targetR, targetC));
        }
    }

    // BFS를 이용해 시작점에서 도착점까지의 최소 이동 횟수를 구하는 메서드
    private static int bfs(int startR, int startC, int targetR, int targetC) {
        // 시작점이 도착점인 경우
        if (startR == targetR && startC == targetC) {
            return 0;
        }

        boolean[][] visited = new boolean[len][len];
        Queue<Position> queue = new LinkedList<>();

        // 시작점 초기화 (이동 횟수 0)
        queue.offer(new Position(startR, startC, 0));
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            Position curr = queue.poll();

            // 나이트의 8가지 이동 경우에 대해 반복
            for (int i = 0; i < 8; i++) {
                int newR = curr.r + dR[i];
                int newC = curr.c + dC[i];

                // 체스판 범위 내에 있는지 확인
                if (newR >= 0 && newR < len && newC >= 0 && newC < len && !visited[newR][newC]) {
                    // 도착점이면 현재 이동 횟수 + 1을 반환
                    if (newR == targetR && newC == targetC) {
                        return curr.moves + 1;
                    }
                    visited[newR][newC] = true;
                    queue.offer(new Position(newR, newC, curr.moves + 1));
                }
            }
        }

        // 모든 경로를 탐색해도 도착점을 찾지 못한 경우 (문제 조건 상 발생하지 않음)
        return -1;
    }

    // 현재 좌표와 이동 횟수를 저장하는 클래스
    static class Position {
        int r, c, moves;

        Position(int r, int c, int moves) {
            this.r = r;
            this.c = c;
            this.moves = moves;
        }
    }
}