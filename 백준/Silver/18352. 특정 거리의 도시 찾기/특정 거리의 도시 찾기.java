import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 이용해 빠른 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        Vector<Vector<Integer>> vertex = new Vector<>(N+1);
        for (int i = 0; i <= N; i++) {
            vertex.add(new Vector<Integer>());
        }Vector<Integer> node = new Vector<>(N+1);
        for (int i = 0; i <= N; i++) {
            node.add(Integer.MAX_VALUE);
        }
        node.set(startX, 0); // 시작 노드의 가중치를 0으로 설정
        for(int i = 0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            vertex.get(a).add(b);
        }
        bfs(node, vertex, startX);
        boolean hasAns = false;
        for(int i = 1;i<=N;i++){
            if(node.get(i) == K){
                hasAns = true;
                System.out.println(i);
            }
        }
        if(!hasAns){
            System.out.println(-1);
        }

    }
    private static void bfs(Vector<Integer> node, Vector<Vector<Integer>> vertex, int startX){
        Queue<Integer> qq = new ArrayDeque<>();
        qq.add(startX);
        while(!qq.isEmpty()){
            int front = qq.poll();
            int len = vertex.get(front).size();
            int next = node.get(front) + 1;
            for(int i = 0;i<len;i++){
                int nextV = vertex.get(front).get(i);
                if(node.get(nextV)>next){
                    node.set(nextV,next);
                    qq.add(nextV);
                }
            }
        }
    }
}
