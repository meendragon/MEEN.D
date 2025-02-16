import java.io.*;
import java.util.*;

public class Main {
    // 간선 정보를 저장하는 클래스
    static class Edge {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 양방향 추가
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        // Prim 알고리즘 준비
        // 우선순위 큐(PriorityQueue)를 사용해 가장 가중치가 낮은 간선부터 선택
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        // 방문 여부를 저장하는 배열로, 방문한 정점을 체크하여 사이클을 방지
        boolean[] visited = new boolean[V + 1];
        long mstCost = 0;
        int count = 0;

        visited[1] = true;
        count++;
        // 시작 정점과 인접한 간선들을 우선순위 큐에 추가
        for (Edge edge : graph[1]) {
            pq.offer(edge);
        }

        // Prim 알고리즘 수행: 모든 정점이 MST에 포함될 때까지 진행
        while (!pq.isEmpty() && count < V) {
            Edge edge = pq.poll();

            if (visited[edge.to]) continue;
            visited[edge.to] = true;
            mstCost += edge.weight;
            count++;
            for (Edge nextEdge : graph[edge.to]) {
                if (!visited[nextEdge.to]) {
                    pq.offer(nextEdge);
                }
            }
        }

        // 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(mstCost));
        bw.flush();
        bw.close();
    }
}