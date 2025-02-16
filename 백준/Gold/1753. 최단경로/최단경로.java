import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader와 StringTokenizer 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화 (ArrayList 사용)
        ArrayList<Edge>[] graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        // 다익스트라 알고리즘 수행
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 우선순위 큐 (최소 힙)
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int curNode = current.to;
            int curWeight = current.weight;

            // 이미 더 짧은 경로가 존재한다면 건너뜁니다.
            if (curWeight > dist[curNode]) continue;

            // 인접한 정점들을 검사
            for (Edge edge : graph[curNode]) {
                int nextNode = edge.to;
                int nextWeight = curWeight + edge.weight;
                if (dist[nextNode] > nextWeight) {
                    dist[nextNode] = nextWeight;
                    pq.offer(new Edge(nextNode, nextWeight));
                }
            }
        }

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= V; i++) {
            bw.write(dist[i] == Integer.MAX_VALUE ? "INF" : String.valueOf(dist[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}