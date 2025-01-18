import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Vector<Vector<Integer>> treeList = new Vector<>(N+1);
        for (int i = 0; i <= N; i++) {
            treeList.add(new Vector<>());
        }
        //2차원배열로 트리 연결리스트 구현
        for (int i = 0; i < N - 1; i++) {
            String userInput = br.readLine();
            String[] tokens = userInput.split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            treeList.get(a).add(b);
            treeList.get(b).add(a);
        }
        //리스트에 노드 연결 상태 표현
        int[] parents = new int[N+1];
        boolean[] nodeCheck = new boolean[N+1];//방문노드 구분방법
        Queue<Integer> qq = new ArrayDeque<>();
        qq.add(1);
        while(!qq.isEmpty()){//BFS 방식으로 탐색
            int front = qq.poll();
            nodeCheck[front] = true;
            for(int num : treeList.get(front)){
                if(!nodeCheck[num]) {
                    parents[num] = front;
                    qq.add(num);
                }
            }
        }
        for(int i = 2;i<=N;i++){
            bw.write(Integer.toString(parents[i]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}