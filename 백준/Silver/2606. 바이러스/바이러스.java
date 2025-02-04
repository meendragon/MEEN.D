import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int vertex = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        int[][] computerGraph = new int[vertex+1][vertex+1];
        for(int i = 0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            computerGraph[start][end] = 1;
            computerGraph[end][start] = 1;
        }
        int ans = bfs(computerGraph, 1)-1;
        sb.append(ans);
        System.out.println(sb);
    }
    private static int bfs(int[][] arr, int start){
        Map<Integer,Integer> visited = new HashMap<>();
        Queue<Integer> qq = new ArrayDeque<>();
        qq.add(start);
        visited.put(start,0);
        while(!qq.isEmpty()){
            int front = qq.poll();
            for(int i = 0;i<arr[front].length;i++){
                if(arr[front][i] == 1 & !visited.containsKey(i)){
                    qq.add(i);
                    visited.put(i,0);
                }
            }
        }
        return (visited.size());
    }

}
